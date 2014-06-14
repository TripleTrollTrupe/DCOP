package lei;

import java.io.IOException;

import model.LEI;
import model.shelves.criteria.ICriterion;
import model.shelves.criteria.RecentlyAddedCriterium;
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
		
		ICriterion crit = new RecentlyAddedCriterium();
		lei.getShelvesHandler().addSmartShelf("smartshelf", crit);

		// start the UI
		StartupUI.run(
				new LEIBookshelfUIDelegate(lei.getShelvesHandler(), lei.getLibraryHandler()),
				new LEIEMediaUIDelegate(), new LEIEMediumMetadataUIDelegate());
	}
}
