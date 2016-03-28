package jtools.eclipse.core.model;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathExpressionException;

/**
 * Classe que representa um arquivo xml
 * 
 * @author jcruz
 *
 */
public interface JxXml {
	
	/**
	 * 
	 * @param exp
	 * @param qname
	 * @return
	 * @throws XPathExpressionException
	 */
	public Object evaluate(String exp, QName qname) throws XPathExpressionException;
}
