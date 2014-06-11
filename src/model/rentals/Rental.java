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
	private boolean expired;
	protected Lendable lendable;
	private ArrayList<String> annotations;
	
	public Rental(Lendable lendable){
		this.lendable=lendable;
		this.timestamp=new Date();
		this.expired=false;
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
		this.expired=false;
	}
	public boolean isExpired(){
		return this.expired;
	}
	//TODO UNSURE FROM HERE ON
	@Override
	public int compareTo(EMedium arg0) {
		return this.lendable.compareTo(arg0);
	}

	@Override
	public File getFile() {
		return this.lendable.getFile();
	}

	@Override
	public String getTitle() {
		return this.lendable.getTitle();
	}

	@Override
	public String getInternetType() {
		return this.lendable.getInternetType();
	}

	@Override
	public EMediumType getType() {
		return this.lendable.getType();
	}

	@Override
	public EMediumPropertiesData getEMediumProperties() {
		return this.lendable.getEMediumProperties();
	}
}
