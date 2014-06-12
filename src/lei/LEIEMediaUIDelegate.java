package lei;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observer;

import services.viewer.NoSuchPageException;
import model.EMedium;
import model.EMediumPropertiesData;
import model.lendables.Lendable;
import model.rentals.RentalFactory;
import model.rentals.BookRental;
import controller.delegates.EMediumUIDelegate;

/**
 * The e-media viewer ui delegate default implementation
 * 
 * @author fmartins
 *
 */
public class LEIEMediaUIDelegate extends EMediumUIDelegate {
	
	private EMedium eMedia;
	private Collection<Observer> observers;
	private int lastpagevisited;
	private BookRental rental;
	
	public void setEMedia (EMedium eMedia) {
		this.eMedia=eMedia;
		// a ultima pagina a aceder foi a primeira
		this.observers= new ArrayList<Observer>();
		this.rental= new BookRental((new Lendable(eMedia.getType(), eMedia.getEMediumProperties())));
	}
	
	@Override
	public void setObservers() {
//		Don't know what to do
	}


	@Override
	public void deleteObservers() {
		for(Observer ob : observers)
			eMedia.deleteObserver(ob);
		observers.removeAll(observers);
	}


	@Override
	public void setLastPageVisited(int pageNum) {
				lastpagevisited=pageNum;
	}


	@Override
	public boolean isBookmarked(int pageNum) {
		try {
			return rental.isBookmarked(pageNum);
		} catch (NoSuchPageException e) {
			return false;
		}
	}


	@Override
	public int getLastPageVisited() {
		return lastpagevisited;
	}

	@Override
	public File getEMediaFile() {
		return eMedia.getFile();
	}


	@Override
	public boolean hasAnnotations(int pageNum) {
		try {
			return rental.hasAnnotations(pageNum);
		} catch (NoSuchPageException e) {
			System.out.println("Pagina não pertence ao livro");
			return false;
		}
	}


	@Override
	public void toggleBookmark(int pageNum) {
		try {
			rental.toggleBookmark(pageNum);
		} catch (NoSuchPageException e) {
			System.out.println("Pagina não pertence ao livro");
		}
	}
	
	@Override
	public EMedium getEMedia() {
		return eMedia;
	}
}
