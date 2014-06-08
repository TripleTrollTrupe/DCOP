package lei;

import java.io.IOException;

import model.LEI;
import view.StartupUI;

/**
 * The main project class
 * 
 * @author fmartins
 *
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		// create the main application class
		LEI lei = new LEI();
		
		// start the UI
		StartupUI.run(new LEIBookshelfUIDelegate(lei.getShelvesHandler(), lei.getLibraryHandler()),  // TODO: fix me with the appropriate facades! 
				new LEIEMediaUIDelegate(), new LEIEMediumMetadataUIDelegate());
	}
}
