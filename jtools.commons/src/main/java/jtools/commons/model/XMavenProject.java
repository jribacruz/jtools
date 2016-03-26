package jtools.commons.model;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.model.base.XDir;
import jtools.commons.model.base.XFile;
import jtools.commons.types.XCollection;

import org.xml.sax.SAXException;

/**
 * Classe que representa um projeto Maven.
 * 
 * @author jcruz
 *
 */
public interface XMavenProject extends Serializable {

	/**
	 * 
	 * @return
	 */
	public XFile getMavenProjectFile();

	/**
	 * Modelo do pom.xml
	 * 
	 * @return
	 */
	public XPom getPom();

	/**
	 * 
	 * Modelo do pretty-config.xml
	 * 
	 * @return
	 */
	public XPrettyConfig gePrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public XPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public XPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException;

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public XCollection<XClass> getSrcMainJavaClasses();

	/**
	 * Coleção com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public XCollection<XClass> getSrcTestJavaClasses();

	/**
	 * 
	 * @return
	 */
	public XCollection<XPackage> getSrcMainJavaPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<XPackage> getSrcTestJavaPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcMainJavaFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcTestJavaFiles();

	/**
	 * Coleção com todos os modelos de arquivos de src/main/webapp
	 * 
	 * @return
	 */
	public XCollection<XDir> getSrcMainWebappDirs();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcMainWebappFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcMainWebappCSSFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcMainWebappJSFiles();

	/**
	 * 
	 * @return
	 */
	public XCollection<XFile> getSrcMainWebappXHTMLFiles();

}
