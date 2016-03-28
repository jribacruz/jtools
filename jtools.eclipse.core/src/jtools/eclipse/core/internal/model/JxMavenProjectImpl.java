package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import jtools.eclipse.core.JxCollection;
import jtools.eclipse.core.internal.model.filter.FilterCSSFile;
import jtools.eclipse.core.internal.model.filter.FilterJSFile;
import jtools.eclipse.core.internal.model.filter.FilterJavaFile;
import jtools.eclipse.core.internal.model.filter.FilterXHTMLFile;
import jtools.eclipse.core.internal.model.function.FunctionJxFileToJxClass;
import jtools.eclipse.core.internal.model.function.FunctionJxFileToJxDir;
import jtools.eclipse.core.internal.model.function.FunctionJxFileToJxPackage;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxMavenProject;
import jtools.eclipse.core.model.JxPackage;
import jtools.eclipse.core.model.JxPersistence;
import jtools.eclipse.core.model.JxPom;
import jtools.eclipse.core.model.JxPrettyConfig;

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
	public JxCollection<JxClass> getSrcMainJavaClasses() {
		return getSrcMainJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public JxCollection<JxClass> getSrcTestJavaClasses() {
		return getSrcTestJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaPackages()
	 */
	@Override
	public JxCollection<JxPackage> getSrcMainJavaPackages() {
		return getMavenProjectFile().find("src/main/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaPackages()
	 */
	@Override
	public JxCollection<JxPackage> getSrcTestJavaPackages() {
		return getMavenProjectFile().find("src/test/java").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxPackage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcMainJavaFiles() {
		return getMavenProjectFile().find("src/main/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcTestJavaFiles() {
		return getMavenProjectFile().find("src/test/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public JxCollection<JxDir> getSrcMainWebappDirs() {
		return getMavenProjectFile().find("src/main/webapp").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcMainWebappFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(FileFileFilter.FILE, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcMainWebappCSSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcMainWebappJSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterJSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public JxCollection<JxFile> getSrcMainWebappXHTMLFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterXHTMLFile(), TrueFileFilter.INSTANCE);
	}

}
