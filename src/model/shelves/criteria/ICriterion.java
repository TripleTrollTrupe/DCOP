package model.shelves.criteria;

import model.rentals.Rental;

/**
 * @author fmartins
 *
 * A smart shelf criterion.
 */
public interface ICriterion {
	
	/**
	 * @param rental The rental to check if it satisfies the criterion.
	 * @return if the rental satisfies the criterion.
	 */
	boolean satisfies (Rental rental);
}
