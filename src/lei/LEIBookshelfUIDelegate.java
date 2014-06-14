package lei;

import java.util.Observable;

import javax.naming.OperationNotSupportedException;

import model.EMedium;
import model.EMediumPropertiesData;
import model.EMediumType;
import model.ILibraryFacade;
import model.IShelvesFacade;
import model.events.RentalAddedEvent;
import model.events.RentalRemovedEvent;
import model.events.ShelfAddedEvent;
import model.events.ShelfRemovedEvent;
import model.rentals.Rental;
import controller.delegates.BookshelfUIDelegate;

/**
 * @author fmartins
 *
 * The bookshelf ui delegate default implementation. This is the class
 * you need to program in order to connect the UI events to your application
 * (the model).
 */
public class LEIBookshelfUIDelegate extends BookshelfUIDelegate {

	private IShelvesFacade shelvesHandler;
	private ILibraryFacade libraryHandler;

	public LEIBookshelfUIDelegate(IShelvesFacade shelvesHandler,
			ILibraryFacade libraryHandler) {
		this.shelvesHandler = shelvesHandler;
		this.libraryHandler = libraryHandler;
		shelvesHandler.addShelfCollectionObserver(this);
		libraryHandler.addObserver(this);
	}

	@Override
	public Iterable<? extends EMedium> getShelfRentals(String selectedShelf) {
		return shelvesHandler.getShelfRentals(selectedShelf);
	}

	@Override
	public Iterable<? extends EMedium> getRentals() {
		return shelvesHandler.getRentals();
	}


	@Override
	public Iterable<? extends EMedium> getLibraryEMedia() {
		return libraryHandler.getEMedia();
	}

	@Override
	public boolean addNormalShelf(String shelfName) {
		return shelvesHandler.addNormalShelf(shelfName);
	}

	@Override
	public void removeShelf(String shelfName) {
		shelvesHandler.removeShelf(shelfName);
	}

	@Override
	public void updateRental(EMedium document,
			EMediumPropertiesData documentProperties) {
		//DO NOTHING
	}

	@Override
	public void removeEMediumShelf(String shelfName, EMedium eMedium) throws OperationNotSupportedException {
		shelvesHandler.removeRental(shelfName, eMedium);
	}

	@Override
	public Iterable<String> getShelves() {
		return shelvesHandler.getShelves();
	}


	@Override
	public boolean addRentalEMedium(EMedium eMedium) {
		return shelvesHandler.addRental(eMedium);
	}


	@Override
	public boolean addEMediumShelf(String shelfName, EMedium eMedium) throws OperationNotSupportedException {
		return shelvesHandler.addShelfRental(shelfName, eMedium);
	}


	@Override
	public String getEMediumTitle(EMedium d) {
		return d.getTitle();	//TODO verify
	}


	@Override
	public void returnRental(EMedium eMedia) {
		shelvesHandler.returnRental(eMedia);
	}


	@Override
	public void revokeLending(EMedium eMedium) {
		shelvesHandler.returnRental(eMedium);
	}

	@Override
	public boolean addEMediumLibrary(String type, EMediumPropertiesData lendableProperties) {
		return libraryHandler.addLendable(EMediumType.valueOf(type.toUpperCase()), lendableProperties);
	}

	@Override
	public boolean canBeViewed(EMedium eMedium) {
		if(eMedium instanceof Rental){
			return !shelvesHandler.isRentalExpired(eMedium);}
		else
			return false;
	}

	@Override
	public boolean isRent(EMedium eMedium) {
		if(eMedium instanceof Rental)
			return shelvesHandler.isRented(eMedium);
		else
			return false;
	}

	@Override
	public void shelfSelected(String selectedShelfName) {
		//do nothing
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if(arg1 instanceof RentalAddedEvent){
			String target = ((RentalAddedEvent) arg1).getTarget();
			EMedium eMed = ((RentalAddedEvent) arg1).getEMedium();
			addToEMediaPanel(target, eMed);
		}
		else if(arg1 instanceof ShelfAddedEvent){
			String shelfName = ((ShelfAddedEvent) arg1).getShelfName();
			addShelfTreeNode(shelfName);
		}
		else if(arg1 instanceof RentalRemovedEvent){
			EMedium eMed = ((RentalRemovedEvent) arg1).getEMedium();
			removeEMediumFromPanel(eMed);
		}
		else if(arg1 instanceof ShelfRemovedEvent){
			String caption = ((ShelfRemovedEvent) arg1).getShelfName();
			removeShelfTreeNode(caption);
		}
	}
}
