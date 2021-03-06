package model;

import java.util.Observer;

import model.lendables.Library;


public class LibraryFacade implements ILibraryFacade {

	private Library library;
	
	public LibraryFacade(){
		this.library = new Library();
	}
	
	@Override
	public Iterable<? extends EMedium> getEMedia() {
		return this.library;
	}

	@Override
	public boolean addLendable(EMediumType type,
			EMediumPropertiesData lendableProperties) {
		return this.library.addLendable(type, lendableProperties);
	}

	@Override
	public EMedium getLastAddedLendable() {
		return this.library.getLastAddedLendable();
	}

	@Override
	public boolean canBeRent(EMedium eMedium) {
		return this.library.canBeRent(eMedium);
	}

	@Override
	public void rent(EMedium eMedium) {
		this.library.rent(eMedium);
	}

	@Override
	public void addObserver(Observer observer) {
		this.library.addObserver(observer);
	}

}
