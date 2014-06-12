package model.events;

import model.EMedium;

public abstract class RentalCollectionEvent {
	
	private EMedium eMedium;
	
	public RentalCollectionEvent(EMedium eMedium) {
		this.eMedium = eMedium;
	}
	
	public EMedium getEMedium(){
		return eMedium;
	}
	
}
