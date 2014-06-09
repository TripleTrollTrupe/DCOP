package model.rentals;

import java.util.ArrayList;
import java.util.List;

import services.viewer.NoSuchPageException;

public class BookRental extends Rental{
	private List<Page> pages;
	private Page lastPageVisited;
	private Lendable book;
	
	public BookRental(Lendable book) {	
	}

	public void addAnnotation(int page, String text) throws NoSuchPageException {
		findPage(page).addAnnotation(text);
	}

	public void removeAnnotation(int pageNum, int n) throws NoSuchPageException {
		findPage(pageNum).removeAnnotation(n);
	}

	public Iterable<String> getAnnotations(int pageNum) throws NoSuchPageException {
		return findPage(pageNum).getAnnotations();
	}

	public boolean hasAnnotations(int n) throws NoSuchPageException {
		return findPage(n).hasAnnotations();

	}

	public boolean isBookmarked(int n) throws NoSuchPageException {
		return findPage(n).isBookmarked();
	}

	public List<Integer> getBookmarks() {
		ArrayList<Integer> bookmarks = new ArrayList<Integer>();
		for(Page p :pages )
			if(p.isBookmarked())
				bookmarks.add(p.getPageNum());
		return bookmarks;
			

	}

	public void toggleBookmark(int n) throws NoSuchPageException {
		Page p = findPage(n); // para correr o algoritmo de busca so uma vez
		if(p.isBookmarked()==true)
			p.bookmark=false;
		else p.bookmark=true;
	}

	public int getLastPageVisited() {
		return lastPageVisited.getPageNum();

	}

	public void setLastPageVisited(int lastPageVisited) throws NoSuchPageException {
		Page p=findPage(lastPageVisited);
		
		

	}
	//TODO pode ser optimizado!
	private Page findPage(int n) throws NoSuchPageException{
		int i = n;
		if (this.pages.get(n).getPageNum() < n) {
			while (i != n && i < pages.size())
				i++;
		} else if(this.pages.get(n).getPageNum() > n){
			while (i != n && i > 0)
				i--;
		}
		if (this.pages.get(i).getPageNum() == n)
			return this.pages.get(i);
		else
			throw new NoSuchPageException();
		
	}

}
