package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

import javax.naming.OperationNotSupportedException;

import model.rentals.RentalFactory;
import model.shelves.IShelf;
import model.shelves.IShelves;
import model.shelves.NormalShelf;
import model.shelves.Shelf;
import model.shelves.Shelves;
import model.shelves.criteria.ICriterion;

public class ShelvesFacade implements IShelvesFacade {
	
	private IShelves shelves;
	private RentalFactory factory;

	public ShelvesFacade(){
		
		NormalShelf myRentals = new NormalShelf("myRentals");
		this.shelves = new Shelves(myRentals);
		factory = new RentalFactory();
	}
	
	@Override
	public boolean addNormalShelf(String name) {
		return shelves.addNormalShelf(name);
	}

	@Override
	public boolean addSmartShelf(String name, ICriterion criteria) {
		return shelves.addSmartShelf(name, criteria);
	}

	@Override
	public void removeShelf(String name) {
		shelves.removeShelf(name);
	}

	@Override
	public Iterable<String> getShelves() {
		List<String> aux = new ArrayList<String>();
		Iterator<Shelf> it = shelves.iterator();
		while(it.hasNext())
			aux.add(it.next().getName());
		return aux;
	}

	@Override
	public boolean addRental(EMedium rental) {
		return shelves.addRental(factory.createRental(rental));
	}

	@Override
	public void returnRental(EMedium rental) {
		try {
			shelves.removeRentalFromShelf("myRentals", factory.createRental(rental));
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean addShelfRental(String shelfName, EMedium rental)
			throws OperationNotSupportedException {
		return shelves.addRentalToShelf(shelfName, factory.createRental(rental));
	}

	@Override
	public void removeRental(String selfName, EMedium rental)
			throws OperationNotSupportedException {
		shelves.removeRentalFromShelf(selfName, factory.createRental(rental));
	}

	@Override
	public Iterable<? extends EMedium> getRentals() {
		return shelves.getRentals();
	}

	@Override
	public Iterable<? extends EMedium> getShelfRentals(String shelfName) {
		return shelves.getShelfRentals(shelfName);
	}

	@Override
	public boolean isRented(EMedium rental) {
		return shelves.isRented(factory.createRental(rental));
	}

	@Override
	public boolean isRentalExpired(EMedium rental) {

		return shelves.isExpired(factory.createRental(rental));
	}

	@Override
	public void addShelfCollectionObserver(Observer observer) {

		shelves.addShelfCollectionObserver(observer);
	}

	@Override
	public void removeShelfCollectionObserver(Observer observer) {
		shelves.removeShelfCollectionObserver(observer);

	}

	@Override
	public void addRentalCollectioObserver(String shelfName, Observer observer) {
		shelves.addRentalCollectionObserver(shelfName, observer);

	}

	@Override
	public void removeRentalCollectionObserver(String shelfName,
			Observer observer) {
		shelves.removeRentalCollectionObserver(shelfName, observer);

	}

}
