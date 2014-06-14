package model.events;

import model.EMedium;
import model.rentals.Page;

public class AnnotationRemovedEvent extends AnnotationEvent {
	
	public AnnotationRemovedEvent(EMedium eMedium, Page page, int annotNum) {
		super(eMedium, page, annotNum);
	}
}
