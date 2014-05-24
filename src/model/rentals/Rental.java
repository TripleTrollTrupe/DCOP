package model.rentals;

import java.io.File;
import java.util.Observable;

import model.EMedium;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Rental extends Observable implements EMedium {

	//TODO: program me!

	@Override
	public int compareTo(EMedium arg0) {
		return 0;
	}

	@Override
	public File getFile() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public String getInternetType() {
		return null;
	}

	@Override
	public EMediumType getType() {
		return null;
	}

	@Override
	public EMediumPropertiesData getEMediumProperties() {
		return null;
	}
}
