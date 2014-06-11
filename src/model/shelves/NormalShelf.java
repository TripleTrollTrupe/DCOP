package model.shelves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import model.rentals.Rental;

public class NormalShelf extends Shelf{
	
	private Collection<Rental> rentals;

	public NormalShelf(String name) {
		super(name);
		this.rentals= new ArrayList<Rental>();
	}

	@Override
	public boolean addRental(Rental rental)
			throws OperationNotSupportedException {
		if(rentals.contains(rental))
			return true;
		rentals.add(rental);
		return false;
	}

	@Override
	public boolean removeRental(Rental rental)
			throws OperationNotSupportedException {
		if(rentals.contains(rental)){
			rentals.remove(rental);
			return true;
		}
		return false;
	}

	@Override
	public Iterator<Rental> iterator() {

		return rentals.iterator();
	}
}
