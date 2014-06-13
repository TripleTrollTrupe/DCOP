package lei;

import java.util.Iterator;
import java.util.Observable;

import model.EMedium;
import model.lendables.Lendable;
import model.rentals.BookRental;
import services.viewer.NoSuchPageException;
import controller.delegates.EMediumMetadataUIDelegate;

/**
 * The document's metadata ui delegate default implementation
 * 
 * @author fmartins
 *
 */
public class LEIEMediumMetadataUIDelegate extends EMediumMetadataUIDelegate {
	
	private BookRental rental;
	
	public void setEMedium (EMedium document) {
		this.rental= new BookRental((new Lendable(document.getType(), document.getEMediumProperties())));

	}
	
	@Override
	public void deleteObservers() {
		//TODO
	}

	@Override
	public Iterable<Integer> getDocumentBookmarks() {
		return this.rental.getBookmarks();
	}

	@Override
	public Iterable<String> getPageAnnotations(int pageNum) {
		return this.rental.getAnnotations();
	}

	@Override
	public String getDocumentTitle() {
		return this.rental.getTitle();
	}

	@Override
	public void addAnnotation(int pageNum, String text) {
		try {
			this.rental.addAnnotation(pageNum, text);
		} catch (NoSuchPageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void removeAnnotation(int pageNum, int annotNum) {
		try {
			this.rental.removeAnnotation(pageNum, annotNum);
		} catch (NoSuchPageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void toggleBookmark(int pageNum) {
		try {
			this.rental.toggleBookmark(pageNum);
		} catch (NoSuchPageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getAnnotationText(int pageNum, int annotNum) {
		return this.getPageAnnotations(pageNum).; //TODO TASUKETE
	}

	@Override
	public void update(Observable arg0, Object hint) {
		//TODO
		
	}

}
