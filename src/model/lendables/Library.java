package model.lendables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.EMedium;
import model.EMediumAttribute;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Library implements Iterable<EMedium> {

	private Collection<EMedium> lendables = new ArrayList<EMedium>();
	private Lendable last;

	public boolean addLendable(EMediumType type, EMediumPropertiesData properties){
		for(EMedium medium : lendables){
			if(medium.getType().equals(type) && 
					properties.getAttribute(EMediumAttribute.PATH).
					equals(medium.getFile().getAbsolutePath()))
				return false;
		}
		Lendable temp = new Lendable(type, properties);
		lendables.add(temp);
		this.last = temp;
		return true;
	}

	public Lendable getLastAddedLendable(){
		return this.last;
	}

	public void rent(EMedium eMedium){
		for(EMedium medium : lendables){
			if(medium.getType().equals(eMedium.getType()) && 
					medium.getFile().equals(eMedium.getFile())){
				((Lendable) medium).rent();
				break;	//nao necessario, apenas para poupar passos, programar com rodinhas era em IP
			}
		}
	}

	public boolean canBeRent(EMedium eMedium){
		for(EMedium medium : lendables){
			if(medium.getType().equals(eMedium.getType()) && 
					medium.getFile().equals(eMedium.getFile()))
				return ((Lendable) medium).hasLicensesAvailable();
		}
		return false;
	}

	@Override
	public Iterator<EMedium> iterator() {
		return lendables.iterator();
	}
}
