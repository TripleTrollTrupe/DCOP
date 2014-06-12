package model.events;

public abstract class ShelfCollectionEvent {
	
	private String ShelfName;

	public ShelfCollectionEvent(String shelfName) {
		ShelfName = shelfName;
	}

	public String getShelfName() {
		return ShelfName;
	}
}
