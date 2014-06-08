package model.shelves;

import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

import model.rentals.Rental;

public class NormalShelf extends Shelf{
	private String name;
	public NormalShelf(String name) {
		super(name);
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean addRental(Rental rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeRental(Rental rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Rental> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(IShelf arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
