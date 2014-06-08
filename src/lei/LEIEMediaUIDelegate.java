package lei;

import java.io.File;

import controller.delegates.EMediumUIDelegate;
import model.EMedium;

/**
 * The e-media viewer ui delegate default implementation
 * 
 * @author fmartins
 *
 */
public class LEIEMediaUIDelegate extends EMediumUIDelegate {
	
	//TODO: program me!
	
	public void setEMedia (EMedium eMedia) {
	}
	
	@Override
	public void setObservers() {
	}


	@Override
	public void deleteObservers() {
	}


	@Override
	public void setLastPageVisited(int pageNum) {
	}


	@Override
	public boolean isBookmarked(int pageNum) {
		return false;
	}


	@Override
	public int getLastPageVisited() {
		return 1;
	}

	@Override
	public File getEMediaFile() {
		return null;
	}


	@Override
	public boolean hasAnnotations(int pageNum) {
		return false;
	}


	@Override
	public void toggleBookmark(int pageNum) {
	}
	
	@Override
	public EMedium getEMedia() {
		return null;
	}
}
