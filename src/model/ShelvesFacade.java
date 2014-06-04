package model;

import java.util.Observer;

import javax.naming.OperationNotSupportedException;

import model.shelves.criteria.ICriterion;

public class ShelvesFacade implements IShelvesFacade {

	@Override
	public boolean addNormalShelf(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSmartShelf(String name, ICriterion criteria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeShelf(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<String> getShelves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRental(EMedium rental) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void returnRental(EMedium rental) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addShelfRental(String shelfName, EMedium rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeRental(String selfName, EMedium rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<EMedium> getRentals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<EMedium> getShelfRentals(String shelfName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRented(EMedium rental) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRentalExpired(EMedium rental) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addShelfCollectionObserver(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeShelfCollectionObserver(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRentalCollectioObserver(String shelfName, Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRentalCollectionObserver(String shelfName,
			Observer observer) {
		// TODO Auto-generated method stub

	}

}
