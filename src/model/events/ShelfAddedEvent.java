package model.events;

public class ShelfAddedEvent extends ShelfCollectionEvent {

	public ShelfAddedEvent(String shelfName) {
		super(shelfName);
	}
}
