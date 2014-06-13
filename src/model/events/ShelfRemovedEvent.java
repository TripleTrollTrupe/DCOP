package model.events;

public class ShelfRemovedEvent extends ShelfCollectionEvent {

	public ShelfRemovedEvent(String shelfName) {
		super(shelfName);
	}
}
