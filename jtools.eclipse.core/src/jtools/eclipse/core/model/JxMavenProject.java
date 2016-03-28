package jtools.eclipse.core.model;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.model.base.JxDir;
import jtools.eclipse.core.model.base.JxFile;

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
	public JxPom getPom();

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
	public JxPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public JxPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public XCollection<JxClass> getSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public XCollection<JxClass> getSrcTestJavaClasses();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxPackage> getSrcMainJavaPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxPackage> getSrcTestJavaPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcMainJavaFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcTestJavaFiles();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public XCollection<JxDir> getSrcMainWebappDirs();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcMainWebappFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcMainWebappCSSFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcMainWebappJSFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxFile> getSrcMainWebappXHTMLFiles();

}
