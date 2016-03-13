package jtools.commons.model;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import jtools.commons.types.TCollection;

/**
 * Modelo do projeto Maven.
 * 
 * @author jcruz
 *
 */
public interface TMMavenProject extends Serializable {

	/**
	 * Modelo do pom.xml
	 * 
	 * @return
	 */
	public TMPom getPom();

	/**
	 * 
	 * Modelo do pretty-config.xml
	 * 
	 * @return
	 */
	public TMPrettyConfig gePrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public TMPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;
	
	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public TMPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * Modelo do persistence.xml de src/test/resources
	 * 
	 * @return
	 */
	public TMPersistence getSrcTestResourcesPersistence();

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public TCollection<TMClass> getSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public TCollection<TMClass> getSrcTestJavaClasses();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public TCollection<TMDir> getSrcMainWebappDirs();

}
