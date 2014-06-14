

package services.viewer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SwingTextViewer {

	private List<String> supportedViewerMimeTypes;
	private String widgetToolkit;
	protected File file;

	public SwingTextViewer(String widgetToolKit) {
		this.widgetToolkit = widgetToolkit;
		loadMimeTypes();
	}

	protected void loadMimeTypes() {
		//TODO uncertain
		List<String> mimeTypes = new ArrayList<String>(1);
		mimeTypes.add("plain/txt");
		setMimeTypes(mimeTypes);
	}

	protected void setMimeTypes(List<String> mimeTypes) {
		//TODO uncertain
		this.supportedViewerMimeTypes = new LinkedList<String>(mimeTypes);
	}

	public Iterable<String> getSupportedViewerMimeTypes() {
		return this.supportedViewerMimeTypes;
	}

	public String getWidgetToolKit() {
		return this.widgetToolkit;
	}

	public void setDocument(File file) throws IOException {
		this.file = file;
	}

	public Object getPage(int pageNum, int width, int height)
			throws NoSuchPageException { //TODO 
		return "TASUKETE";

	}

	public boolean canSlideShow() {
		//TODO
		return false;
	}
}