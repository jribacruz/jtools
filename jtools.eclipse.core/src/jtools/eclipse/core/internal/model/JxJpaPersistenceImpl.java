package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import jtools.eclipse.core.model.JxJpaPersistence;
import jtools.eclipse.core.util.JxCollection;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author jcruz
 *
 */
public class JxJpaPersistenceImpl extends JxXmlImpl implements JxJpaPersistence {

	/**
	 * 
	 * @param xmlFile
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public JxJpaPersistenceImpl(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
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
	public JxCollection<String> findAllClasses() {
		JxCollection<String> classes = new JxCollection<>();
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
	public Map<String, String> findAllProperties() {
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