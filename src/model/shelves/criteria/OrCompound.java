package model.shelves.criteria;

import model.rentals.Rental;

public class OrCompound extends CompoundCriterium {

	public OrCompound(ICriterion left, ICriterion right) {
		super(left, right);
	}

	@Override
	public boolean satisfies(Rental rental) {
		return (getLeft().satisfies(rental) || getRight().satisfies(rental));
	}

}
