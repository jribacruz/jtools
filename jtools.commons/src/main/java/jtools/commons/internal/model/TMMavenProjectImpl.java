package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.model.TMClass;
import jtools.commons.model.TMMavenProject;
import jtools.commons.model.TMPersistence;
import jtools.commons.model.TMPom;
import jtools.commons.model.TMPrettyConfig;
import jtools.commons.model.base.TMDir;
import jtools.commons.types.TCollection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.xml.sax.SAXException;

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
		TCollection<TMClass> classes = new TCollection<>();
		for (File file : FileUtils.listFiles(new File("src/main/java"), new SuffixFileFilter(".java"), TrueFileFilter.INSTANCE)) {
			try {
				classes.add(new TMClassImpl(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public TCollection<TMClass> getSrcTestJavaClasses() {
		TCollection<TMClass> classes = new TCollection<>();
		for (File file : FileUtils.listFiles(new File("src/test/java"), new SuffixFileFilter(".java"), TrueFileFilter.INSTANCE)) {
			try {
				classes.add(new TMClassImpl(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return classes;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappCSSFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappJSFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappXHTMLFiles() {
		return null;
	}

}
