package jtools.commons.model;

import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import jtools.commons.model.base.MFile;
import jtools.commons.model.base.MXml;
import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo persistence.xml
 * 
 * @author jcruz
 *
 */
public interface MPersistence extends MXml {

	/**
	 * 
	 * Retorna a versão do arquivo persistence.xml
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public String getVersion();

	/**
	 * 
	 * Retorna o nome da unidade de persistencia.
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
	 * Retorna as classes registradas no arquivo persistence.xml
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
