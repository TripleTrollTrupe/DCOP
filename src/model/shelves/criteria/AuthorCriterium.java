package model.shelves.criteria;

import model.EMediumAttribute;
import model.rentals.Rental;

public class AuthorCriterium implements ICriterion {

	private Object author;
	
	public AuthorCriterium(String author) {
		this.author = author;
	}

	@Override
	public boolean satisfies(Rental rental) {
		return rental.getEMediumProperties().getAttribute(EMediumAttribute.AUTHOR)
				.equals(author);
	}

}
