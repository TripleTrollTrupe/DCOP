package model.shelves;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import model.rentals.Rental;
import model.shelves.criteria.ICriterion;

public class SmartShelf extends Shelf{
	
	private Shelf myRentals;
	private ICriterion criterium;

	public SmartShelf(String name, Shelf myRentals, ICriterion criterium) {
		super(name);
		this.myRentals=myRentals;
		this.criterium=criterium;
	}

	@Override
	public boolean addRental(Rental rental)
			throws OperationNotSupportedException {
	
		throw new OperationNotSupportedException();
	}

	@Override
	public boolean removeRental(Rental rental)
			throws OperationNotSupportedException {
	
		throw new OperationNotSupportedException();
	}

	@Override
	public Iterator<Rental> iterator() {
		
		List<Rental> auxiliar = new ArrayList<Rental>();
		
		for(Rental rental : myRentals)
			if(criterium.satisfies(rental))
				auxiliar.add(rental);
		
		return auxiliar.iterator();
	}
}
