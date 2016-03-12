package jtools.commons.model;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathExpressionException;

public interface TMXml {
	public Object evaluate(String exp, QName qname) throws XPathExpressionException;
}
