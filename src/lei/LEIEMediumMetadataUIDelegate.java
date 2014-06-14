package lei;

import java.util.LinkedList;
import java.util.Observable;

import model.EMedium;
import model.events.AnnotationAddedEvent;
import model.events.AnnotationRemovedEvent;
import model.events.BookmarkToggleEvent;
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

	private EMedium document;

	public void setEMedium (EMedium document) {
		this.document = document;
		this.document.addObserver(this);

	}

	@Override
	public void deleteObservers() {
		document.deleteObserver(this);
	}

	@Override
	public Iterable<Integer> getDocumentBookmarks() {
		if(document instanceof BookRental)
			return ((BookRental) document).getBookmarks();
		else return null; //TODO verify if no kaboom
	}

	@Override
	public Iterable<String> getPageAnnotations(int pageNum) {
		if(document instanceof BookRental)
			try {
				return ((BookRental) document).getAnnotations(pageNum);
			} catch (NoSuchPageException e) {
				System.out.println("404 Page not found(getPageAnnot)");
			}
		return new LinkedList<String>();
	}

	@Override
	public String getDocumentTitle() {
		return document.getTitle();
	}

	@Override
	public void addAnnotation(int pageNum, String text) {
		if(document instanceof BookRental)
			try {
				((BookRental) document).addAnnotation(pageNum, text);
			} catch (NoSuchPageException e) {
				System.out.println("404 Page not found(addAnnot)");
			}
	}

	@Override
	public void removeAnnotation(int pageNum, int annotNum) {
		if(document instanceof BookRental)
			try {
				((BookRental) document).removeAnnotation(pageNum, annotNum);;
			} catch (NoSuchPageException e) {
				System.out.println("404 Page not found");
				e.printStackTrace();
			}
	}

	@Override
	public void toggleBookmark(int pageNum) {
		if(document instanceof BookRental)
			try {
				((BookRental) document).toggleBookmark(pageNum);;
			} catch (NoSuchPageException e) {
				System.out.println("404 Page not found");
				e.printStackTrace();
			}
	}

	@Override
	public String getAnnotationText(int pageNum, int annotNum) {
		return ((BookRental) document).getAnnotationText(pageNum, annotNum);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof AnnotationAddedEvent){
			String text = ((AnnotationAddedEvent) arg1).getAnnotationText();
			addAnnotationTreeNode(text);
		}

		else if(arg1 instanceof AnnotationRemovedEvent){
			int annotationNum = ((AnnotationRemovedEvent) arg1).getAnnotationNum();
			removeAnnotationTreeNode(annotationNum);
		}

		else if(arg1 instanceof BookmarkToggleEvent){
			int pageNum = ((BookmarkToggleEvent) arg1).getPageNum();
			boolean active = ((BookmarkToggleEvent) arg1).isBookmarked();
			if(active)
				addBookmarkTreeNode(pageNum);
			else
				removeBookmarkTreeNode(pageNum);
		}
	}
}
