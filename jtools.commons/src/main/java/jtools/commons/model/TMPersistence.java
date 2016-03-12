package jtools.commons.model;

import javax.xml.xpath.XPathExpressionException;

import jtools.commons.types.TCollection;

/**
 * Modelo do arquivo persistence.xml
 * 
 * @author jcruz
 *
 */
public interface TMPersistence {

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException 
	 */
	public String getVersion() throws XPathExpressionException;

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException 
	 */
	public String getPersistenceUnitName() throws XPathExpressionException;

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException 
	 */
	public String getTransactionType() throws XPathExpressionException;

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException 
	 */
	public TCollection<String> getClasses() throws XPathExpressionException;

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPersistenceProperty> getProperties();

}
