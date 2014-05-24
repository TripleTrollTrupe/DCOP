package lei;

import java.util.LinkedList;
import java.util.Observable;

import javax.naming.OperationNotSupportedException;

import controller.delegates.BookshelfUIDelegate;
import model.EMedium;
import model.EMediumPropertiesData;
import model.ILibraryFacade;
import model.IShelvesFacade;

/**
 * @author fmartins
 *
 * The bookshelf ui delegate default implementation. This is the class
 * you need to program in order to connect the UI events to your application
 * (the model).
 */
public class LEIBookshelfUIDelegate extends BookshelfUIDelegate {

	// TODO: program me!

	public LEIBookshelfUIDelegate(IShelvesFacade shelvesHandler,
			ILibraryFacade libraryHandler) {
	}

	@Override
	public Iterable<EMedium> getShelfRentals(String selectedShelf) {
		return new LinkedList<EMedium>();
	}
	
	@Override
	public Iterable<EMedium> getRentals() {
		return new LinkedList<EMedium>();
	}


	@Override
	public Iterable<EMedium> getLibraryEMedia() {
		return new LinkedList<EMedium>();
	}

	@Override
	public boolean addNormalShelf(String shelfName) {
		return false;
	}

	@Override
	public void removeShelf(String shelfName) {
	}

	@Override
	public void updateRental(EMedium document,
			EMediumPropertiesData documentProperties) {
	}

	@Override
	public void removeEMediumShelf(String shelfName, EMedium eMedium) throws OperationNotSupportedException {
	}
	
	@Override
	public Iterable<String> getShelves() {
		return new LinkedList<String>();
	}

	
	@Override
	public boolean addRentalEMedium(EMedium eMedium) {
		return false;
	}

	
	@Override
	public boolean addEMediumShelf(String shelfName, EMedium eMedium) throws OperationNotSupportedException {
		return false;
	}
		

	@Override
	public String getEMediumTitle(EMedium d) {
		return "Title";
	}
	

	@Override
	public void returnRental(EMedium eMedia) {
	}

	
	@Override
	public void revokeLending(EMedium eMedium) {
	}

	@Override
	public boolean addEMediumLibrary(String type, EMediumPropertiesData lendableProperties) {
		return false;
	}

	@Override
	public boolean canBeViewed(EMedium eMedium) {
		return false;
	}

	@Override
	public boolean isRent(EMedium eMedium) {
		return false;
	}

	@Override
	public void shelfSelected(String selectedShelfName) {
	}

	@Override
	public void update(Observable arg0, Object arg1) {
	}

}
