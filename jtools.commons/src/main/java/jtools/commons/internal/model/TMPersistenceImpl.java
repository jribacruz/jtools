package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import jtools.commons.model.TMPersistence;
import jtools.commons.model.TMPersistenceProperty;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMPersistenceImpl extends TMXmlImpl implements TMPersistence {

	/**
	 * 
	 * @param xmlFile
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public TMPersistenceImpl(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		super(xmlFile);
	}

	@Override
	public String getVersion() throws XPathExpressionException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getPersistenceUnitName()
	 */
	@Override
	public String getPersistenceUnitName() throws XPathExpressionException {
		Node node = (Node) super.evaluate("/persistence/persistence-unit", XPathConstants.NODE);
		return node.getAttributes().getNamedItem("name").getNodeValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getTransactionType()
	 */
	@Override
	public String getTransactionType() throws XPathExpressionException {
		Node node = (Node) super.evaluate("/persistence/persistence-unit", XPathConstants.NODE);
		return node.getAttributes().getNamedItem("transaction-type").getNodeValue();
	}

	@Override
	public TCollection<String> getClasses() throws XPathExpressionException {
		TCollection<String> classes = new TCollection<>();
		NodeList nodeList = (NodeList) super.evaluate("/persistence/persistence-unit/class", XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
			System.out.println(String.format("NodeName : %s , Value: %s",nodeList.item(i).getNodeName(), nodeList.item(i).getFirstChild().getNodeValue()));
		}
		return classes;
	}

	@Override
	public TCollection<TMPersistenceProperty> getProperties() {
		return null;
	}

}
