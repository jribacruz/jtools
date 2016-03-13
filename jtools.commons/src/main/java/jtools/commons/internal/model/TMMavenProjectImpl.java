package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import jtools.commons.model.TMClass;
import jtools.commons.model.TMDir;
import jtools.commons.model.TMMavenProject;
import jtools.commons.model.TMPersistence;
import jtools.commons.model.TMPom;
import jtools.commons.model.TMPrettyConfig;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMMavenProjectImpl implements TMMavenProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getPom()
	 */
	@Override
	public TMPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public TMPrettyConfig gePrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public TMPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = new File("src/main/resources/META-INF/persistence.xml");
		return new TMPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public TMPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = new File("src/test/resources/META-INF/persistence.xml");
		return new TMPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public TCollection<TMClass> getSrcMainJavaClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public TCollection<TMClass> getSrcTestJavaClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcTestResourcesPersistence()
	 */
	@Override
	public TMPersistence getSrcTestResourcesPersistence() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappDirs() {
		return null;
	}

}
