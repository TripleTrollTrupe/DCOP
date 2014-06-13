package model.lendables;

import java.io.File;
import java.util.Observable;

import model.EMedium;
import model.EMediumAttribute;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Lendable extends Observable implements EMedium {

	private EMediumType type;
	private EMediumPropertiesData properties;
	private File file;
	private int licenses;

	public Lendable(EMediumType type, EMediumPropertiesData properties) {
		this.type = type;
		this.properties = properties;
		this.file = new File((String) properties.getAttribute(EMediumAttribute.PATH));
		this.licenses = (int) properties.getAttribute(EMediumAttribute.LICENSES);
	}

	public void rent(){
		if (hasLicensesAvailable()) 
			licenses--;
	}

	public boolean hasLicensesAvailable(){
		return licenses > 0;
	}

	@Override
	public int compareTo(EMedium o) {
		String title1 = (String) this.getTitle();
		String title2 = (String) o.getTitle();
		return title1.compareTo(title2);
	}

	@Override
	public File getFile() {
		return this.file;
	}

	@Override
	public String getTitle() {
		return (String) this.properties.getAttribute(EMediumAttribute.TITLE);
	}

	@Override
	public String getInternetType() {
		return (String) this.properties.getAttribute(EMediumAttribute.INTERNET_TYPE);
	}

	@Override
	public EMediumType getType() {
		return this.type;
	}

	@Override
	public EMediumPropertiesData getEMediumProperties() {
		return this.properties;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lendable other = (Lendable) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (type != other.type)
			return false;
		return true;
	}


}
