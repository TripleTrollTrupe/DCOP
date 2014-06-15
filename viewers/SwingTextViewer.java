
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import services.viewer.NoSuchPageException;
import services.viewer.Viewer;


public class SwingTextViewer extends Viewer {

	public SwingTextViewer() {
		super("swing");
	}

	@Override
	protected void loadMimeTypes() {
		List<String> mimeTypes = new ArrayList<String>(1);
		mimeTypes.add("text/plain");
		setMimeTypes (mimeTypes);
	}

	@Override
	public Object getPage(int pageNum, int width, int height)
			throws NoSuchPageException {
		if(pageNum < 1)
			throw new NoSuchPageException();

		// get lines from file

		StringBuilder textB = new StringBuilder("");

		try{
			BufferedReader in = new BufferedReader(new FileReader(super.file));
			String line = "";
			while((line = in.readLine()) != null){
				textB.append(line + "\n");
			}
			in.close();
		}catch(Exception e){}// Well this is embarassing

		String [] text = textB.delete(textB.length()-1, textB.length()).toString().split("\n");

		//prepare measures and "canvas"

		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		
		g.setColor(Color.white);
		g.fillRect( 0, 0, image.getWidth(), image.getHeight() );
		

		g.setColor(Color.black);

		//*unused*         int widthForText = width-30; // 15,15
		int heightForText = height-30; // 15,15 square
		int newline = g.getFontMetrics().getHeight() + g.getFontMetrics().getMaxDescent();
		//*unused*         int maxCharsLine = (int) Math.floor(widthForText/g.getFontMetrics().getMaxAdvance());
		int maxLinesPage = (int) Math.floor(heightForText/newline);

		//start calculating/writing pages

		int currPage = 1;
		int currLine = 0;
		int maxLine = text.length;
		
		System.out.println(textB.toString());
		
		while(currPage <= pageNum && currLine < maxLine){ // hasn't gone past selected page or document last line

			int lineNum = 1; // start from line 1 in page, begining of page
			int x = 15, y = 15;   //starting coordinates of text in page

			while(lineNum <= maxLinesPage && currLine < maxLine){ // hasn't exceeded max lines in page or document
				
				if(currPage == pageNum){ // if current page is the selected one
					g.drawString(text[currLine], x, y);
					y += newline;
				}
				
				currLine++;   // advance current line
				lineNum++;    // advance line
			}
			
			if(currLine == maxLine && currPage != pageNum)
				throw new NoSuchPageException();
			currPage++;   // advance page
		}

		//return image
		return image;
	}

	@Override
	public boolean canSlideshow() {
		return true;
	}


}