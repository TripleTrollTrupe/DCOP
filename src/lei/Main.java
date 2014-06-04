package lei;

import java.io.IOException;

import model.ILibraryFacade;
import model.IShelvesFacade;
import model.LEI;
import model.LibraryFacade;
import model.ShelvesFacade;
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
			
		// TODO: obtain the façades from the application
		// ...
		IShelvesFacade shelvesHandler = null;//new ShelvesFacade();
		ILibraryFacade libraryHandler = new LibraryFacade();
		
		// start the UI
		StartupUI.run(new LEIBookshelfUIDelegate(shelvesHandler, libraryHandler),  // TODO: fix me with the appropriate facades! 
				new LEIEMediaUIDelegate(), new LEIEMediumMetadataUIDelegate());
	}
}
