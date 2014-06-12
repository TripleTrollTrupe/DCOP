package model.events;

import model.EMedium;

public class AnnotationRemovedEvent extends AnnotationEvent {

	public AnnotationRemovedEvent(EMedium eMedium, int pageNum,
			int annotationNum, boolean annotated) {
		super(eMedium, pageNum, annotationNum, annotated);
	}
}
