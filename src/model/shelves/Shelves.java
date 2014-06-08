package model.shelves;

import java.util.Iterator;
import java.util.Observer;

import javax.naming.OperationNotSupportedException;

import model.rentals.Rental;
import model.shelves.criteria.ICriterion;

public class Shelves implements IShelves{

	public Shelves() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterator<IShelf> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Método que acrescenta uma NormalShelf a lista de Shelfs existentes
	 * @param name Nome da Shelf a criar e a adicionar
	 * @return Se a Shelf foi adicionada
	 */
	@Override
	public boolean addNormalShelf(String name) {
		// Cria a nova Shelf, é preciso ver se ja existia uma com o mesmo nome, se foi possivel
		// acrescenta-la a lista
		NormalShelf ola= new NormalShelf(name);
		return false;
	}
	
	/**
	 * Método que acrescenta uma SmartShelf a lista de Shelfs existentes
	 * @param name Nome da Shelf a criar e a adicionar
	 * @param criterion O criterion que o e-medium tem de satisfazer
	 * @return Se a Shelf foi adicionada
	 */
	@Override
	public boolean addSmartShelf(String name, ICriterion criterion) {
		// Cria a nova Shelf, é preciso ver se ja existia uma com o mesmo nome, se foi possivel
		// acrescenta-la a lista
		Shelf teste= new Shelf(name);
		SmartShelf ola= new SmartShelf(name ,teste, criterion);
		return false;
	}
	
	/**
	 * Método que remove uma Shelf da lista de Shelfs existentes
	 * @param name Nome da Shelf a remover
	 */
	@Override
	public void removeShelf(String name) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param name The name of the shelf to check if it is the rental shelf
	 * @return if the shelf *name* is the rental shelf
	 */
	@Override
	public boolean isTheRentalShelf(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @param rental The rental to add to the Rental shelf
	 * @return if the rental was added to the rental shelf
	 */
	@Override
	public boolean addRental(Rental rental) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @param target The self to add the rental to
	 * @param rental The rental to be added to the *target* shelf
	 * @return if the *rental* was added to the *target* shelf 
	 * @throws OperationNotSupportedException In case the shelf does not support
	 * 			the adding of rentals.
	 */
	@Override
	public boolean addRentalToShelf(String target, Rental rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * @param name The name of the shelf to remove the *rental* from
	 * @param rental The rental to be removed from the *name* shelf
	 * @throws OperationNotSupportedException In case the shelf does not support
	 * 			the removal of rentals.
	 */
	@Override
	public void removeRentalFromShelf(String name, Rental rental)
			throws OperationNotSupportedException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return The rentals from the rentals shelf
	 */
	@Override
	public Iterable<Rental> getRentals() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param shelfName The shelf name to get the rentals from
	 * @return The rentals in the *shelfName* self.
	 */
	@Override
	public Iterable<Rental> getShelfRentals(String shelfName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param rental The rental to check if it has ever been rented by
	 * 			this user.
	 * @return if the rental was ever rented by this user
	 */
	@Override
	public boolean isRented(Rental rental) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param rental The rental to check if it is expired
	 * @return if the rental (was rented before) and is now expired
	 */
	@Override
	public boolean isExpired(Rental rental) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @param observer The observer to be added
	 * 
	 * Adds an observer to be notified when shelves are added or removed
	 */
	@Override
	public void addShelfCollectionObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

   /**
     * @param observer The observer to be removed
     * 
     * Removes an observer from the collection of shelves
     */
	@Override
	public void removeShelfCollectionObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

    /**
     * @param shelfName The name of the shelf to be observed
     * @param observer The observer to be added
     * 
     * Adds an observer to the *shelfName* shelf that gets notified whenever
     * a rental is added or removed in the shelf.
     */
	@Override
	public void addRentalCollectionObserver(String shelfName, Observer observer) {
		// TODO Auto-generated method stub
		
	}

    /**
     * @param shelfName The name of the shelf to remove the observer
     * @param observer The observer to be removed
     * 
     * Remove an observer the is listening to events happening at *shelfName* shelf
     */
	@Override
	public void removeRentalCollectionObserver(String shelfName,
			Observer observer) {
		// TODO Auto-generated method stub
		
	}

}
