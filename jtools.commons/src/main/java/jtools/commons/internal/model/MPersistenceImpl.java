package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import jtools.commons.internal.model.base.MXmlImpl;
import jtools.commons.model.MPersistence;
import jtools.commons.types.TCollection;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author jcruz
 *
 */
public class MPersistenceImpl extends MXmlImpl implements MPersistence {

	/**
	 * 
	 * @param xmlFile
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public MPersistenceImpl(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
		super(xmlFile);
	}

	@Override
	public String getVersion() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getPersistenceUnitName()
	 */
	@Override
	public String getPersistenceUnitName() {
		try {
			Node node = (Node) super.evaluate("/persistence/persistence-unit", XPathConstants.NODE);
			return node.getAttributes().getNamedItem("name").getNodeValue();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getTransactionType()
	 */
	@Override
	public String getTransactionType() {
		try {
			Node node = (Node) super.evaluate("/persistence/persistence-unit", XPathConstants.NODE);
			return node.getAttributes().getNamedItem("transaction-type").getNodeValue();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getClasses()
	 */
	@Override
	public TCollection<String> getClasses() {
		TCollection<String> classes = new TCollection<>();
		try {
			NodeList nodeList = (NodeList) super.evaluate("/persistence/persistence-unit/class", XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				classes.add(nodeList.item(i).getFirstChild().getNodeValue());
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPersistence#getProperties()
	 */
	@Override
	public Map<String, String> getProperties() {
		Map<String, String> properties = new HashMap<>();
		try {
			NodeList nodeList = (NodeList) super.evaluate("/persistence/persistence-unit/properties/property", XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				String name = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
				String value = nodeList.item(i).getAttributes().getNamedItem("value").getNodeValue();
				properties.put(name, value);
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
