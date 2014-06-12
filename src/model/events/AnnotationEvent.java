package model.events;

import model.EMedium;

public abstract class AnnotationEvent extends EMediumEvent {

	private int annotationNum;
	private boolean annotated;
	
	public AnnotationEvent(EMedium eMedium, int pageNum, int annotationNum,
			boolean annotated) {
		super(eMedium, pageNum);
		this.annotationNum = annotationNum;
		this.annotated = annotated;
	}
	
	@Override
	public int getPageNum(){
		return super.getPageNum();
	}

	public int getAnnotationNum() {
		return annotationNum;
	}

	public boolean hasAnnotations() {
		return annotated;
	}
}
