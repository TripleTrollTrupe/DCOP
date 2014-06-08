package model.shelves;

import java.util.Observable;


public abstract class Shelf extends Observable implements IShelf {
		String name;
	public Shelf(String name) {
		this.name=name;
	}

}
