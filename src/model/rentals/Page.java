package model.rentals;

import java.util.ArrayList;
import java.util.List;

public class Page {
	public boolean bookmark;
	private int pageNum;
	private List<String> annotations;

	public Page(int pageNum) {
		this.pageNum = pageNum;
		this.bookmark = false;
		this.annotations = new ArrayList<String>();
	}

	public void addAnnotation(String text) {
		this.annotations.add(text);
	}

	public Iterable<String> getAnnotations() {
		return this.annotations;
	}

	public String getAnnotationText(int n) {
		return annotations.get(n);
	}

	public int getPageNum() {
		return this.pageNum;
	}
	public void removeAnnotation(int n){
		this.annotations.remove(n);
	}

	public boolean hasAnnotations() {
		return !this.annotations.isEmpty();
	}

	public boolean isBookmarked() {
		return this.bookmark;
	}

}
