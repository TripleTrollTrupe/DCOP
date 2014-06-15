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
		this.lendable.rent();
	}
	public Date getRentalTimestamp(){
		return this.timestamp;
	}
	public void addAnnotation(String text){
		this.annotations.add(text);
	}
	public void removeAnnotation(int n){
		this.annotations.remove(n);
		
	}
	public Iterable <String> getAnnotations(){
		return annotations;
	}
	public void renew(){
		this.timestamp=new Date();
		this.expired=false;
		this.lendable.rent();
	}
	public boolean isExpired(){
		return this.expired;
	}	
	
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
	
	public void returnRental(){
		this.expired = true;
		this.lendable.unRent();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lendable == null) ? 0 : lendable.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rental other = (Rental) obj;
		if (lendable == null) {
			if (other.lendable != null)
				return false;
		} else if (!lendable.equals(other.lendable))
			return false;
		return true;
	}
}
