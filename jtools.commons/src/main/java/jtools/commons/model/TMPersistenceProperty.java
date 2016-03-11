package jtools.commons.model;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface TMPersistenceProperty extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public String getValue();
}
