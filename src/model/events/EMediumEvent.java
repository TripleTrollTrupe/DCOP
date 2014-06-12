package model.events;

import model.EMedium;

public abstract class EMediumEvent {

	private EMedium eMedium;
	private int pageNum;
	
	public EMediumEvent(EMedium eMedium, int pageNum) {
		this.eMedium = eMedium;
		this.pageNum = pageNum;
	}
	
	public EMedium getEMedium(){
		return eMedium;
	}
	
	public int getPageNum(){
		return pageNum;
	}
	
}
