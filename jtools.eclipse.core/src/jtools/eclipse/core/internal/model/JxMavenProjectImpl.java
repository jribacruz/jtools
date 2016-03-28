package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.internal.filter.FilterCSSFile;
import jtools.eclipse.core.internal.filter.FilterJSFile;
import jtools.eclipse.core.internal.filter.FilterJavaFile;
import jtools.eclipse.core.internal.filter.FilterXHTMLFile;
import jtools.eclipse.core.internal.function.FunctionJxFileToJxClass;
import jtools.eclipse.core.internal.function.FunctionJxFileToJxDir;
import jtools.eclipse.core.internal.function.FunctionJxFileToJxPackage;
import jtools.eclipse.core.internal.model.base.JxFileImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxMavenProject;
import jtools.eclipse.core.model.JxPackage;
import jtools.eclipse.core.model.JxPersistence;
import jtools.eclipse.core.model.JxPom;
import jtools.eclipse.core.model.JxPrettyConfig;
import jtools.eclipse.core.model.base.JxDir;
import jtools.eclipse.core.model.base.JxFile;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.xml.sax.SAXException;

/**
 * 
 * @author jcruz
 *
 */
public class JxMavenProjectImpl implements JxMavenProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JxFile mavenProjectFile;

	public JxMavenProjectImpl(String mavenProjectPath) {
		super();
		this.mavenProjectFile = new JxFileImpl(new File(mavenProjectPath));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getMavenProjectFile()
	 */
	public JxFile getMavenProjectFile() {
		return this.mavenProjectFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getPom()
	 */
	@Override
	public JxPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public JxPrettyConfig gePrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public JxPersistence geSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/main/resources/META-INF/persistence.xml").getFile();
		return new JxPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public JxPersistence geSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/test/resources/META-INF/persistence.xml").getFile();
		return new JxPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public XCollection<JxClass> getSrcMainJavaClasses() {
		return getSrcMainJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public XCollection<JxClass> getSrcTestJavaClasses() {
		return getSrcTestJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaPackages()
	 */
	@Override
	public XCollection<JxPackage> getSrcMainJavaPackages() {
		return getMavenProjectFile().find("src/main/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaPackages()
	 */
	@Override
	public XCollection<JxPackage> getSrcTestJavaPackages() {
		return getMavenProjectFile().find("src/test/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcMainJavaFiles() {
		return getMavenProjectFile().find("src/main/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcTestJavaFiles() {
		return getMavenProjectFile().find("src/test/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public XCollection<JxDir> getSrcMainWebappDirs() {
		return getMavenProjectFile().find("src/main/webapp").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcMainWebappFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(FileFileFilter.FILE, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcMainWebappCSSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcMainWebappJSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterJSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public XCollection<JxFile> getSrcMainWebappXHTMLFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterXHTMLFile(), TrueFileFilter.INSTANCE);
	}

}
