package jtools.eclipse.core.model;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import jtools.eclipse.core.util.JxCollection;

import org.xml.sax.SAXException;

/**
 * Classe que representa um projeto Maven.
 * 
 * @author jcruz
 *
 */
public interface JxMavenProject extends Serializable {

	/**
	 * 
	 * @return
	 */
	public JxFile getMavenProjectFile();

	/**
	 * Modelo do pom.xml
	 * 
	 * @return
	 */
	public JxMavenPom getPom();

	/**
	 * 
	 * Modelo do pretty-config.xml
	 * 
	 * @return
	 */
	public JxPrettyConfig gePrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public JxJpaPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public JxJpaPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClass> getSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClass> getSrcTestJavaClasses();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> getSrcMainJavaPackages();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> getSrcTestJavaPackages();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcMainJavaFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcTestJavaFiles();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public JxCollection<JxDir> getSrcMainWebappDirs();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcMainWebappFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcMainWebappCSSFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcMainWebappJSFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> getSrcMainWebappXHTMLFiles();

}
