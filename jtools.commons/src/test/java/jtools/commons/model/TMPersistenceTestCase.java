package jtools.commons.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.xml.sax.SAXException;

import jtools.commons.internal.model.MPersistenceImpl;

@RunWith(JUnit4.class)
public class TMPersistenceTestCase {

	@Test
	public void initTest() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		MPersistence persistence = new MPersistenceImpl(new File("src/test/java/persistence.xml"));
		Assert.assertTrue(persistence.getPersistenceUnitName().equals("jtools.commons"));
	}
	
	@Test
	public void initTest2() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		MPersistence persistence = new MPersistenceImpl(new File("src/test/java/persistence.xml"));
		System.out.println(persistence.getClasses());
		//Assert.assertTrue(persistence.getPersistenceUnitName().equals("jtools.commons"));
	}
	
	@Test
	public void initTest3() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		MPersistence persistence = new MPersistenceImpl(new File("src/test/java/persistence.xml"));
		System.out.println(persistence.getProperties());
		//Assert.assertTrue(persistence.getPersistenceUnitName().equals("jtools.commons"));
	}
}
