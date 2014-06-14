package model.shelves.criteria;

import java.util.Date;

import model.rentals.Rental;

public class RecentlyAddedCriterium implements ICriterion {

	@Override
	public boolean satisfies(Rental rental) {
		Date rentalTime = rental.getRentalTimestamp();
		Date time = new Date();
		
		System.out.println(time.getTime() - rentalTime.getTime());
		
		if(time.getTime() - rentalTime.getTime() < 300000) //last 5 mins
			return true;
		else
			return false;
	}

}
