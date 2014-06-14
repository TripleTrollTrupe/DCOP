

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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

		Image image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		int widthForText = width-10;
		int newline = g.getFontMetrics().getHeight() + 5;
		
		//TODO WRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
		
		return image;
	}

	@Override
	public boolean canSlideshow() {
		return true;
	}


}