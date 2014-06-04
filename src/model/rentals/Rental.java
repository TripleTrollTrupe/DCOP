package model.rentals;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

import model.EMedium;
import model.EMediumPropertiesData;
import model.EMediumType;
import model.lendables.Lendable;

public class Rental extends Observable implements EMedium {

	private Date timestamp;
	private Date today=new Date();
	private boolean expired;
	private Lendable content;
	private ArrayList<String> annotations;
	
	public Rental(Lendable lendable){
		this.content=lendable;
		this.timestamp=new Date();
		this.expired=timestamp.compareTo(today)<0;
		this.annotations=new ArrayList<String>();
	}
	public Date getRentalTimestamp(){
		return this.timestamp;
	}
	public void addAnnotation(String text){
		this.annotations.add(text);
	}
	public void remoteAnnotation(int n){
		this.annotations.remove(n);
		
	}
	public Iterable <String> getAnnotations(){
		return annotations;
	}
	public void renew(){
		this.timestamp=new Date();
	}
	public boolean isExpired(){
		return this.expired;
	}

	@Override
	public int compareTo(EMedium arg0) {
		return 0;
	}

	@Override
	public File getFile() {
		return this.content.getFile();
	}

	@Override
	public String getTitle() {
		return this.content.getTitle();
	}

	@Override
	public String getInternetType() {
		return this.content.getInternetType();
	}

	@Override
	public EMediumType getType() {
		return this.content.getType();
	}

	@Override
	public EMediumPropertiesData getEMediumProperties() {
		return this.content.getEMediumProperties();
	}
}
