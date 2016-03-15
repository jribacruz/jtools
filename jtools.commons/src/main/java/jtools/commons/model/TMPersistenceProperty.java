package jtools.commons.model;

import java.io.Serializable;

/**
 * 
 * Classe que representa uma prorpriedade do persistence.xml
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
