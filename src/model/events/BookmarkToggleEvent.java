package model.events;

import model.EMedium;

public class BookmarkToggleEvent extends EMediumEvent {

	private boolean bookmarked;
	
	public BookmarkToggleEvent(EMedium eMedium, int pageNum, boolean bookmarked) {
		super(eMedium, pageNum);
		this.bookmarked = bookmarked;
	}

	public boolean isBookmarked() {
		return bookmarked;
	}
}
