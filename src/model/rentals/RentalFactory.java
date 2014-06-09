package model.rentals;

import model.EMedium;
import model.lendables.Lendable;

public class RentalFactory{
	public static Rental createRental(EMedium m){
		return new Rental((Lendable) m);
	}
}
