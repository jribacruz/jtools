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
	public JxPrettyConfig getPrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public JxJpaPersistence getSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public JxJpaPersistence getSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClass> findAllSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClass> findAllSrcTestJavaClasses();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcMainJavaFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcTestJavaFiles();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public JxCollection<JxDir> findAllSrcMainWebappDirs();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcMainWebappFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcMainWebappCSSFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcMainWebappJSFiles();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxFile> findAllSrcMainWebappXHTMLFiles();

	/**
	 * 
	 * @param fullyQualifiedName
	 * @return
	 */
	public JxJavaClass findSrcMainJavaClassByFullyQualifiedName(String fullyQualifiedName);
	
	/**
	 * 
	 * @param fullyQualifiedName
	 * @return
	 */
	public JxJavaClass findSrcTestJavaClassByFullyQualifiedName(String fullyQualifiedName);

}
