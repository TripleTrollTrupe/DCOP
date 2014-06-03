package model.lendables;

import java.util.Iterator;

import model.EMedium;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Library implements Iterable<Library> {

	public boolean addLendable(EMediumType type, EMediumPropertiesData properties){
		//TODO
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
		// TODO Auto-generated method stub
		return null;
	}

}
