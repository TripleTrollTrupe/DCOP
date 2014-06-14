package model.events;

import model.EMedium;
import model.rentals.Page;

public abstract class AnnotationEvent extends EMediumEvent {

	private Page p;
	private int annotNum;
	
	public AnnotationEvent(EMedium eMedium, Page page, int annotNum) {
		super(eMedium, page.getPageNum());
		this.p = page;
		this.annotNum = annotNum;
	}
	
	@Override
	public int getPageNum(){
		return super.getPageNum();
	}

	public int getAnnotationNum() {
		return annotNum;
	}

	public boolean hasAnnotations() {
		return p.hasAnnotations();
	}
}
