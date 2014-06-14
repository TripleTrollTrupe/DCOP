package model.shelves.criteria;

import java.util.Date;

import model.rentals.Rental;

public class RecentlyAddedCriterium implements ICriterion {

	private Date time;

	public RecentlyAddedCriterium() {
		this.time = new Date();
	}

	@Override
	public boolean satisfies(Rental rental) {
		Date rentalTime = rental.getRentalTimestamp();
		if(time.getTime() - rentalTime.getTime() < 300000) //last 5 mins
			return true;
		else
			return false;
	}

}
