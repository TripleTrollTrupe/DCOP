package model.events;

import model.EMedium;

public class AnnotationAddedEvent extends AnnotationEvent {

	private String annotationText;

	public AnnotationAddedEvent(EMedium eMedium, int pageNum,
			int annotationNum, boolean annotated, String annotationText) {
		super(eMedium, pageNum, annotationNum, annotated);
		this.annotationText = annotationText;
	}

	public String getAnnotationText() {
		return annotationText;
	}
}
