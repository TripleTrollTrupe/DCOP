package model.shelves;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
		if(rentals.contains(rental)){
			for(Rental r : rentals)
				if(r.equals(rental))
					r.renew();
			return false;
		}
		rentals.add(rental);
		return true;
	}

	@Override
	public boolean removeRental(Rental rental)
			throws OperationNotSupportedException {
		if(!rentals.contains(rental)){
			return false;
		}
		rentals.remove(rental);
		return true;
	}

	@Override
	public Iterator<Rental> iterator() {
		return rentals.iterator();
	}
}
