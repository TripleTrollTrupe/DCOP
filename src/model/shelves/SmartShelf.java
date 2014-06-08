package model.shelves;

import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

import model.rentals.Rental;
import model.shelves.criteria.ICriterion;

public class SmartShelf extends Shelf{
	String name;
	Shelf myRentals;
	// que fazer....?
	ICriterion criterium;
	Iterator<Rental> iterador;
	public SmartShelf(String name, Shelf myRentals, ICriterion criterium) {
		super(name);
		this.name=name;
		this.myRentals=myRentals;
		this.criterium=criterium;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
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
		iterador=iterator();
		Boolean removido = false;
		while(iterador.hasNext() && removido){
			if(iterador.next().getTitle() == rental.getTitle()){
				iterador.remove();
				removido=true;
			}
			else
				iterador.next();
		}
		return false;
	}

	@Override
	public Iterator<Rental> iterator() {
		Iterator<Rental> itr= new myRentals.iterator();
		return itr;
	}

	@Override
	public int compareTo(IShelf o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
