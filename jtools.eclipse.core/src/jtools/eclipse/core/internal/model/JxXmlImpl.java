package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jtools.eclipse.core.model.JxXml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author jcruz
 *
 */
public class JxXmlImpl implements JxXml {

	private File xmlFile;

	private Document doc;

	private XPath xpath;

	public JxXmlImpl(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		super();
		this.xmlFile = xmlFile;
		init();
	}

	/**
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected void init() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		this.doc = builder.parse(xmlFile);
		XPathFactory xPathfactory = XPathFactory.newInstance();
		this.xpath = xPathfactory.newXPath();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMXml#getExpression(java.lang.String)
	 */
	@Override
	public Object evaluate(String exp, QName qname) throws XPathExpressionException {
		XPathExpression expr = xpath.compile(exp);
		return expr.evaluate(doc, qname);
	}

}
