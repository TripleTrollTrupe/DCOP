package model.events;

import model.EMedium;

public class RentalAddedEvent extends RentalCollectionEvent {

	private String target;
	
	public RentalAddedEvent(EMedium eMedium, String target) {
		super(eMedium);
		this.target = target;
	}

	public String getTarget() {
		return this.target;
	}
}
