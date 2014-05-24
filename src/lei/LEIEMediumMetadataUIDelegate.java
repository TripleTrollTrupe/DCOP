package lei;

import java.util.LinkedList;
import java.util.Observable;

import controller.delegates.EMediumMetadataUIDelegate;
import model.EMedium;

/**
 * The document's metadata ui delegate default implementation
 * 
 * @author fmartins
 *
 */
public class LEIEMediumMetadataUIDelegate extends EMediumMetadataUIDelegate {
	
	//TODO: program me!
	
	public void setEMedium (EMedium document) {
	}
	
	@Override
	public void deleteObservers() {
	}

	@Override
	public Iterable<Integer> getDocumentBookmarks() {
		return new LinkedList<Integer>();
	}

	@Override
	public Iterable<String> getPageAnnotations(int pageNum) {
		return new LinkedList<String>();
	}

	@Override
	public String getDocumentTitle() {
		return "title";
	}

	@Override
	public void addAnnotation(int pageNum, String text) {
	}

	@Override
	public void removeAnnotation(int pageNum, int annotNum) {
	}

	@Override
	public void toggleBookmark(int pageNum) {
	}

	@Override
	public String getAnnotationText(int pageNum, int annotNum) {
		return "";
	}

	@Override
	public void update(Observable arg0, Object hint) {
	}

}
