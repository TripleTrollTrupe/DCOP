package model.shelves.criteria;

import model.rentals.Rental;

public abstract class CompoundCriterium implements ICriterion {

	private ICriterion left;
	private ICriterion right;
	
	public CompoundCriterium(ICriterion left, ICriterion right) {
		this.left = left;
		this.right = right;
	}

	public ICriterion getLeft() {
		return left;
	}

	public ICriterion getRight() {
		return right;
	}

	@Override
	public abstract boolean satisfies(Rental rental);

}
