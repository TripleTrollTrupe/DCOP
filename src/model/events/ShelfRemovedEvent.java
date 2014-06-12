package model.events;

import model.EMedium;

public class ShelfRemovedEvent extends RentalCollectionEvent {

	public ShelfRemovedEvent(EMedium eMedium) {
		super(eMedium);
	}
}
