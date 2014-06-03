package model.lendables;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import model.EMedium;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Library implements Iterable<Library> {

	private Collection<Lendable> lendables = new HashSet<Lendable>();
	
	public boolean addLendable(EMediumType type, EMediumPropertiesData properties){
		
		return false;
	}
	
	public Lendable getLastAddedLendable(){
		//TODO
		return null;
	}
	
	public void rent(EMedium eMedium){
		//TODO
	}
	
	public boolean canBeRent(EMedium eMedium){
		//TODO
		return false;
	}
	
	@Override
	public Iterator<Library> iterator() {
		// TODO
		return null;
	}

}
