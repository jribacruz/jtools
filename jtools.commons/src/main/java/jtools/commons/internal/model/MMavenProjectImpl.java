package jtools.commons.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.commons.exception.InvalidProjectTypeException;
import jtools.commons.filter.FilterCSSFile;
import jtools.commons.filter.FilterJSFile;
import jtools.commons.filter.FilterJavaFile;
import jtools.commons.filter.FilterXHTMLFile;
import jtools.commons.function.FunctionMFileToMDir;
import jtools.commons.function.FunctionMFileToMPackage;
import jtools.commons.function.FunctionMFileToMClass;
import jtools.commons.internal.model.base.MFileImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.XMavenProject;
import jtools.commons.model.XPackage;
import jtools.commons.model.XPersistence;
import jtools.commons.model.XPom;
import jtools.commons.model.XPrettyConfig;
import jtools.commons.model.base.XDir;
import jtools.commons.model.base.XFile;
import jtools.commons.types.XCollection;
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
public class MMavenProjectImpl implements XMavenProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private XFile mavenProjectFile;

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
	public XFile getMavenProjectFile() {
		return this.mavenProjectFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getPom()
	 */
	@Override
	public XPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public XPrettyConfig gePrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public XPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/main/resources/META-INF/persistence.xml").getFile();
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public XPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/test/resources/META-INF/persistence.xml").getFile();
		return new MPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public XCollection<XClass> getSrcMainJavaClasses() {
		return getSrcMainJavaFiles().transform(new FunctionMFileToMClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public XCollection<XClass> getSrcTestJavaClasses() {
		return getSrcTestJavaFiles().transform(new FunctionMFileToMClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaPackages()
	 */
	@Override
	public XCollection<XPackage> getSrcMainJavaPackages() {
		return getMavenProjectFile().find("src/main/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionMFileToMPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaPackages()
	 */
	@Override
	public XCollection<XPackage> getSrcTestJavaPackages() {
		return getMavenProjectFile().find("src/test/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionMFileToMPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaFiles()
	 */
	@Override
	public XCollection<XFile> getSrcMainJavaFiles() {
		return getMavenProjectFile().find("src/main/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaFiles()
	 */
	@Override
	public XCollection<XFile> getSrcTestJavaFiles() {
		return getMavenProjectFile().find("src/test/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public XCollection<XDir> getSrcMainWebappDirs() {
		return getMavenProjectFile().find("src/main/webapp").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionMFileToMDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public XCollection<XFile> getSrcMainWebappFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(FileFileFilter.FILE, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public XCollection<XFile> getSrcMainWebappCSSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public XCollection<XFile> getSrcMainWebappJSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterJSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public XCollection<XFile> getSrcMainWebappXHTMLFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterXHTMLFile(), TrueFileFilter.INSTANCE);
	}

}
