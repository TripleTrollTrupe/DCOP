package model;

/**
 * @author fmartins
 *
 * The properties of an e-medium. For the sake of being as general 
 * as possible, we do not impose attributes (besides its type,
 * file, and title) to e-medium. Instead we should maintain a 
 * collection of the EMediumAttribute and its associated value.
 * 
 * Elements of the class should be clonal.  
 */
public class EMediumPropertiesData implements Cloneable {

	/**
	 * @param attribute The attribute to get the value from
	 * @return The value of the attribute identified by *attribute*
	 */
	public Object getAttribute(EMediumAttribute attribute) {
		return null; //TODO: program me!
	}

	/**
	 * Add/Changes a medium attribute given its id and value
	 *  
	 * @param attribute The attribute id to add/change
	 * @param value The value of the attribute
	 */
	public void addAttribute(EMediumAttribute attribute, Object value) {
		//TODO: program me!
	}
	
	/**
	 * @param type The type to check if the e-medium is a member of
	 * @return If the e-medium is of type *type*
	 */
	public boolean isMediumType(EMediumType type) {
		return false; //TODO: program me! 
	}
	
	@Override
	public EMediumPropertiesData clone() {
		return null; //TODO: program me!
	}
}
