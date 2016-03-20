package jtools.commons.model;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.model.base.MDir;
import jtools.commons.types.TCollection;

import org.xml.sax.SAXException;

/**
 * Classe que representa um projeto Maven.
 * 
 * @author jcruz
 *
 */
public interface MMavenProject extends Serializable {

	/**
	 * Modelo do pom.xml
	 * 
	 * @return
	 */
	public MPom getPom();

	/**
	 * 
	 * Modelo do pretty-config.xml
	 * 
	 * @return
	 */
	public MPrettyConfig gePrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public MPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public MPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public TCollection<MClass> getSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public TCollection<MClass> getSrcTestJavaClasses();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public TCollection<MDir> getSrcMainWebappDirs();

	/**
	 * 
	 * @return
	 */
	public TCollection<MDir> getSrcMainWebappFiles();

	/**
	 * 
	 * @return
	 */
	public TCollection<MDir> getSrcMainWebappCSSFiles();

	/**
	 * 
	 * @return
	 */
	public TCollection<MDir> getSrcMainWebappJSFiles();

	/**
	 * 
	 * @return
	 */
	public TCollection<MDir> getSrcMainWebappXHTMLFiles();

}
