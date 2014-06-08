package model;


/**
 * @author fmartins
 *
 *	The main class of the application that is responsible for
 *	starting up the application.
 */
public class LEI {

	public LibraryFacade getLibraryHandler(){
		return new LibraryFacade();
	}
	
	public ShelvesFacade getShelvesHandler(){
		return new ShelvesFacade();
	}
}
