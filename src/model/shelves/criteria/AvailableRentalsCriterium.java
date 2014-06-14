package model.shelves.criteria;

import model.rentals.Rental;

public class AvailableRentalsCriterium implements ICriterion {

	public AvailableRentalsCriterium() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean satisfies(Rental rental) {
		return true; //TODO
	}

}
