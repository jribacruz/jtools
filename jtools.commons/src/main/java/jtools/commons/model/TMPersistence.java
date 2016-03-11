package jtools.commons.model;

import jtools.commons.types.TCollection;

public interface TMPersistence {

	/**
	 * 
	 * @return
	 */
	public String getVersion();

	/**
	 * 
	 * @return
	 */
	public String getPersistenceUnitName();

	/**
	 * 
	 * @return
	 */
	public String getTransactionType();

	/**
	 * 
	 * @return
	 */
	public TCollection<String> getClasses();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPersistenceProperty> getProperties();

}
