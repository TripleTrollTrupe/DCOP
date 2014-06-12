package model.lendables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.EMedium;
import model.EMediumAttribute;
import model.EMediumPropertiesData;
import model.EMediumType;

public class Library implements Iterable<Lendable> {

	private List<Lendable> lendables;

	public Library() {
		this.lendables = new ArrayList<Lendable>();
	}

	public boolean addLendable(EMediumType type,
			EMediumPropertiesData properties) {
		for (EMedium medium : lendables) {
			if (medium.getType().equals(type)
					&& properties.getAttribute(EMediumAttribute.PATH).equals(
							medium.getFile().getAbsolutePath()))
				return false;
		}
		lendables.add(new Lendable(type, properties));
		return true;
	}

	public Lendable getLastAddedLendable() {
		return this.lendables.get(lendables.size()-1);
	}

	public void rent(EMedium eMedium) {
		for (EMedium medium : lendables) {
			if (medium.getType().equals(eMedium.getType())
					&& medium.getFile().equals(eMedium.getFile())) {
				((Lendable) medium).rent();
				break; // nao necessario, apenas para poupar passos, programar
						// com rodinhas era em IP
			}
		}
	}

	public boolean canBeRent(EMedium eMedium) {
		for (EMedium medium : lendables) {
			if (medium.getType().equals(eMedium.getType())
					&& medium.getFile().equals(eMedium.getFile()))
				return ((Lendable) medium).hasLicensesAvailable();
		}
		return false;
	}

	@Override
	public Iterator<Lendable> iterator() {
		return lendables.iterator();
	}
}
