package model.events;

import model.EMedium;
import model.rentals.Page;

public class AnnotationAddedEvent extends AnnotationEvent {

	private String annotationText;

	public AnnotationAddedEvent(EMedium eMedium, Page page, int annotNum, String text){
		super(eMedium, page, annotNum);
		this.annotationText = text;
	}

	public String getAnnotationText() {
		return annotationText;
	}
}
