package lei;

import java.io.File;
import java.util.Observable;

import model.EMedium;
import model.events.AnnotationAddedEvent;
import model.events.AnnotationRemovedEvent;
import model.events.BookmarkToggleEvent;
import model.rentals.BookRental;
import services.viewer.NoSuchPageException;
import controller.delegates.EMediumUIDelegate;

/**
 * The e-media viewer ui delegate default implementation
 * 
 * @author fmartins
 *
 */
public class LEIEMediaUIDelegate extends EMediumUIDelegate {

	private EMedium eMedia;

	public void setEMedia (EMedium eMedia) {
		this.eMedia=eMedia;
		this.eMedia.addObserver(this); //TODO check if not dupped with method
	}

	@Override
	public void setObservers() {
		eMedia.addObserver(this); //TODO verify, probably correct
	}


	@Override
	public void deleteObservers() {
		eMedia.deleteObserver(this); //TODO yea, I think it checks out
	}


	@Override
	public void setLastPageVisited(int pageNum) {
		if(eMedia instanceof BookRental)
			try {
				((BookRental) eMedia).setLastPageVisited(pageNum);
			} catch (NoSuchPageException e) {
				e.printStackTrace();
			}
	}


	@Override
	public boolean isBookmarked(int pageNum) {
		if(eMedia instanceof BookRental){
			try {
				return ((BookRental) eMedia).isBookmarked(pageNum);
			} catch (NoSuchPageException e) {
				System.out.println("Pagina não pertence ao livro(isBookmarked)");
			}
		}
		return false;
	}


	@Override
	public int getLastPageVisited() {
		if(eMedia instanceof BookRental)
				return ((BookRental) eMedia).getLastPageVisited();
		else
			return 1;
	}

	@Override
	public File getEMediaFile() {
		return eMedia.getFile();
	}


	@Override
	public boolean hasAnnotations(int pageNum) {
		if(eMedia instanceof BookRental){
			try {
				return ((BookRental) eMedia).hasAnnotations(pageNum);
			} catch (NoSuchPageException e) {
				System.out.println("Pagina não pertence ao livro(hasAnnotations)");
			}
		}
		return false;
	}


	@Override
	public void toggleBookmark(int pageNum) {//TODO notify observers in method called
		if(eMedia instanceof BookRental){
			try {
				((BookRental) eMedia).toggleBookmark(pageNum);
			} catch (NoSuchPageException e) {
				System.out.println("Pagina não pertence ao livro(toggleBookmark)");
			}
		}
	}

	@Override
	public EMedium getEMedia() {
		return eMedia;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof AnnotationAddedEvent){
			int pageNum = ((AnnotationAddedEvent) arg1).getPageNum();
			boolean hasAnnotations = ((AnnotationAddedEvent) arg1).hasAnnotations();
			updateAnnotationsLabel(pageNum, hasAnnotations);
		}

		else if(arg1 instanceof AnnotationRemovedEvent){
			int pageNum = ((AnnotationRemovedEvent) arg1).getPageNum();
			boolean hasAnnotations = ((AnnotationRemovedEvent) arg1).hasAnnotations();
			updateAnnotationsLabel(pageNum, hasAnnotations);
		}

		else if(arg1 instanceof BookmarkToggleEvent){
			int pageNum = ((BookmarkToggleEvent) arg1).getPageNum();
			boolean active = ((BookmarkToggleEvent) arg1).isBookmarked();
			updateBookmarkLabel(pageNum, active);
		}
	}
}
