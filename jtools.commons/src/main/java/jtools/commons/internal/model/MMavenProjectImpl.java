package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.exception.InvalidProjectTypeException;
import jtools.commons.filter.FilterCSSFile;
import jtools.commons.filter.FilterJSFile;
import jtools.commons.filter.FilterJavaFile;
import jtools.commons.filter.FilterXHTMLFile;
import jtools.commons.function.FunctionMFileToMClass;
import jtools.commons.internal.model.base.MFileImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.MMavenProject;
import jtools.commons.model.MPersistence;
import jtools.commons.model.MPom;
import jtools.commons.model.MPrettyConfig;
import jtools.commons.model.base.MFile;
import jtools.commons.types.TCollection;
import jtools.commons.util.MavenProject;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
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

	private MFile mavenProjectFile;

	public MMavenProjectImpl(String mavenProjectPath) throws InvalidProjectTypeException {
		super();
		if (!MavenProject.isMavenProject(mavenProjectPath)) {
			throw new InvalidProjectTypeException("O projeto não é maven.");
		}
		this.mavenProjectFile = new MFileImpl(new File(mavenProjectPath));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getMavenProjectFile()
	 */
	public MFile getMavenProjectFile() {
		return this.mavenProjectFile;
	}

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
		File filePersistence = getMavenProjectFile().find("src/main/resources/META-INF/persistence.xml").getFile();
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public MPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/test/resources/META-INF/persistence.xml").getFile();
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public TCollection<MClass> getSrcMainJavaClasses() {
		return getSrcMainJavaFiles().transform(new FunctionMFileToMClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public TCollection<MClass> getSrcTestJavaClasses() {
		return getSrcTestJavaFiles().transform(new FunctionMFileToMClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaFiles()
	 */
	@Override
	public TCollection<MFile> getSrcMainJavaFiles() {
		return getMavenProjectFile().find("src/main/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaFiles()
	 */
	@Override
	public TCollection<MFile> getSrcTestJavaFiles() {
		return getMavenProjectFile().find("src/test/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public TCollection<MFile> getSrcMainWebappDirs() {
		return getMavenProjectFile().find("src/main/webapp").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public TCollection<MFile> getSrcMainWebappFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(FileFileFilter.FILE, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public TCollection<MFile> getSrcMainWebappCSSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public TCollection<MFile> getSrcMainWebappJSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterJSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public TCollection<MFile> getSrcMainWebappXHTMLFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterXHTMLFile(), TrueFileFilter.INSTANCE);
	}

}
