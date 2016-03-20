package jtools.commons.model;

import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo persistence.xml
 * 
 * @author jcruz
 *
 */
public interface MPersistence {

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getVersion();

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getPersistenceUnitName();

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getTransactionType();

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public TCollection<String> getClasses();

	/**
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public Map<String, String> getProperties();

}
