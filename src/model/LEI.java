package model;


/**
 * @author fmartins
 *
 *	The main class of the application that is responsible for
 *	starting up the application.
 */
public class LEI {
	
	private LibraryFacade lib;
	private ShelvesFacade shelves;

	public LEI(){
		this.lib = new LibraryFacade();
		this.shelves = new ShelvesFacade();
	}
	
	public LibraryFacade getLibraryHandler(){
		return lib;
	}
	
	public ShelvesFacade getShelvesHandler(){
		return shelves;
	}
}
