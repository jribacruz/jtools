package jtools.eclipse.core.model;

import java.util.Map;

import javax.xml.xpath.XPathExpressionException;

import jtools.eclipse.core.util.JxCollection;

/**
 * Classe que representa um arquivo persistence.xml
 * 
 * @author jcruz
 *
 */
public interface JxJpaPersistence extends JxXml {

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
	public JxCollection<String> getClasses();

	/**
	 * 
	 * Lista de propriedades do persistence.xml
	 * 
	 * @return
	 * @throws XPathExpressionException
	 */
	public Map<String, String> getProperties();

}
