package model.rentals;

import model.EMedium;
import model.EMediumType;
import model.lendables.Lendable;

public class RentalFactory {

	private static RentalFactory instance;
	
	public static RentalFactory getInstance () {
		if (instance == null)
			instance = new RentalFactory();
		return instance;
	}
	
	private RentalFactory(){
		super();
	}

	public Rental createRental(EMedium m) {

		if (m.getType() == EMediumType.DOCUMENT)
			return new BookRental(new Lendable(m.getType(),
					m.getEMediumProperties()));
		else
			return new Rental(new Lendable(m.getType(),
					m.getEMediumProperties()));
	}
}
