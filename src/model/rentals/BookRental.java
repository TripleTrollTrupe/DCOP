package model.rentals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.events.AnnotationAddedEvent;
import model.events.AnnotationRemovedEvent;
import model.events.BookmarkToggleEvent;
import model.lendables.Lendable;
import services.viewer.NoSuchPageException;

public class BookRental extends Rental {

	private Map<Integer, Page> pages;
	private int lastPageVisited;
	private List<Integer> bookmarks;

	public BookRental(Lendable book) {
		super(book);
		this.pages = new HashMap<Integer, Page>();
		this.lastPageVisited = 1;
		this.bookmarks = new ArrayList<Integer>();
	}

	public void addAnnotation(int page, String text) throws NoSuchPageException {
		if (this.pages.containsKey(page))
			pages.get(page).addAnnotation(text);
		else {
			Page p = new Page(page);
			pages.put(page, p);
			pages.get(page).addAnnotation(text);
		}
		Iterator<String> it = this.getAnnotations(page).iterator();
		int i =0;
		while(it.hasNext()){
			i++;
			it.next();
		}
		setChanged();
		notifyObservers(new AnnotationAddedEvent(this, pages.get(page), i, text));
	}

	public void removeAnnotation(int pageNum, int n) throws NoSuchPageException {
		if (this.pages.containsKey(pageNum)){
			this.pages.get(pageNum).removeAnnotation(n);
			setChanged();
			notifyObservers(new AnnotationRemovedEvent(this, this.pages.get(pageNum),
					n));
		}
		else
			throw new NoSuchPageException();
	}

	public Iterable<String> getAnnotations(int pageNum)
			throws NoSuchPageException {
		if (this.pages.containsKey(pageNum))
			return pages.get(pageNum).getAnnotations();
		else
			throw new NoSuchPageException();
	}
	
	public String getAnnotationText(int pageNum, int n){
		return this.pages.get(pageNum).getAnnotationText(n);
	}

	public boolean hasAnnotations(int n) throws NoSuchPageException {
		if (this.pages.containsKey(n))
			return pages.get(n).hasAnnotations();
		else
			//a pagina nao existe, logo not has annotations
			return false;
			//throw new NoSuchPageException();

	}

	public boolean isBookmarked(int n) throws NoSuchPageException {
		if (this.pages.containsKey(n))
			return pages.get(n).isBookmarked();
		else
			//a pagina nao existe, logo not bookmarked
			return false;
			//throw new NoSuchPageException();
	}

	public List<Integer> getBookmarks() {
		return bookmarks;
	}

	public void toggleBookmark(int n) throws NoSuchPageException {//TODO correct this method

		if(this.pages.containsKey(n)){
			if (pages.get(n).isBookmarked() == true) {
				pages.get(n).toggleBoorkmark();
				this.bookmarks.remove(this.bookmarks.indexOf(n));
				setChanged();
				notifyObservers(new BookmarkToggleEvent(lendable, n, false));
				System.out.println("bkmk to false");
			} else if (pages.get(n).isBookmarked() == false) {
				pages.get(n).toggleBoorkmark();
				this.bookmarks.add(n);
				setChanged();
				notifyObservers(new BookmarkToggleEvent(lendable, n, true));
				System.out.println("bkmk to true");
			}
		}
		else{
			Page p = new Page(n);
			pages.put(n, p);
			p.toggleBoorkmark();
			this.bookmarks.add(n);
			setChanged();
			notifyObservers(new BookmarkToggleEvent(lendable, n, true));
			System.out.println("new bkmk to true");
		}
		//throw new NoSuchPageException() nunca sera necessario
	}
	public int getLastPageVisited() {
		return lastPageVisited;

	}

	public void setLastPageVisited(int lastPageVisited)
			throws NoSuchPageException {
		this.lastPageVisited = lastPageVisited;
	}

}
