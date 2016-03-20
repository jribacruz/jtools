package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.model.MClass;
import jtools.commons.model.MMavenProject;
import jtools.commons.model.MPersistence;
import jtools.commons.model.MPom;
import jtools.commons.model.MPrettyConfig;
import jtools.commons.model.base.MDir;
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
public class MMavenProjectImpl implements MMavenProject {

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
	public MPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public MPrettyConfig gePrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public MPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = new File("src/main/resources/META-INF/persistence.xml");
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public MPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = new File("src/test/resources/META-INF/persistence.xml");
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public TCollection<MClass> getSrcMainJavaClasses() {
		TCollection<MClass> classes = new TCollection<>();
		for (File file : FileUtils.listFiles(new File("src/main/java"), new SuffixFileFilter(".java"), TrueFileFilter.INSTANCE)) {
			try {
				classes.add(new MClassImpl(file));
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
	public TCollection<MClass> getSrcTestJavaClasses() {
		TCollection<MClass> classes = new TCollection<>();
		for (File file : FileUtils.listFiles(new File("src/test/java"), new SuffixFileFilter(".java"), TrueFileFilter.INSTANCE)) {
			try {
				classes.add(new MClassImpl(file));
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
	public TCollection<MDir> getSrcMainWebappDirs() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public TCollection<MDir> getSrcMainWebappFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public TCollection<MDir> getSrcMainWebappCSSFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public TCollection<MDir> getSrcMainWebappJSFiles() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public TCollection<MDir> getSrcMainWebappXHTMLFiles() {
		return null;
	}

}
