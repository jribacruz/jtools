package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.xml.sax.SAXException;

import jtools.eclipse.core.internal.model.filter.FilterCSSFile;
import jtools.eclipse.core.internal.model.filter.FilterJSFile;
import jtools.eclipse.core.internal.model.filter.FilterJavaFile;
import jtools.eclipse.core.internal.model.filter.FilterXHTMLFile;
import jtools.eclipse.core.internal.model.function.FunctionJxFileToJxClass;
import jtools.eclipse.core.internal.model.function.FunctionJxFileToJxDir;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJpaPersistence;
import jtools.eclipse.core.model.JxMavenPom;
import jtools.eclipse.core.model.JxMavenProject;
import jtools.eclipse.core.model.JxPrettyConfig;
import jtools.eclipse.core.util.JxCollection;

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
	public JxMavenPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public JxPrettyConfig getPrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public JxJpaPersistence getSrcMainResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/main/resources/META-INF/persistence.xml").getFile();
		return new JxJpaPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#geSrcTestResourcesPersistence()
	 */
	@Override
	public JxJpaPersistence getSrcTestResourcesPersistence() throws ParserConfigurationException, SAXException, IOException {
		File filePersistence = getMavenProjectFile().find("src/test/resources/META-INF/persistence.xml").getFile();
		return new JxJpaPersistenceImpl(filePersistence);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public JxCollection<JxJavaClass> findAllSrcMainJavaClasses() {
		return findAllSrcMainJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public JxCollection<JxJavaClass> findAllSrcTestJavaClasses() {
		return findAllSrcTestJavaFiles().transform(new FunctionJxFileToJxClass());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcMainJavaFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcMainJavaFiles() {
		return getMavenProjectFile().find("src/main/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.MMavenProject#getSrcTestJavaFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcTestJavaFiles() {
		return getMavenProjectFile().find("src/test/java").filter(new FilterJavaFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public JxCollection<JxDir> findAllSrcMainWebappDirs() {
		return getMavenProjectFile().find("src/main/webapp").filter(DirectoryFileFilter.DIRECTORY, TrueFileFilter.INSTANCE)
				.transform(new FunctionJxFileToJxDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcMainWebappFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(FileFileFilter.FILE, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappCSSFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcMainWebappCSSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappJSFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcMainWebappJSFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterJSFile(), TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappXHTMLFiles()
	 */
	@Override
	public JxCollection<JxFile> findAllSrcMainWebappXHTMLFiles() {
		return getMavenProjectFile().find("src/main/webapp").filter(new FilterXHTMLFile(), TrueFileFilter.INSTANCE);
	}

	@Override
	public JxJavaClass findSrcMainJavaClassByFullyQualifiedName(String fullyQualifiedName) {
		for (JxJavaClass javaClass : findAllSrcMainJavaClasses()) {
			if (javaClass.getFullyQualifiedName().equals(fullyQualifiedName)) {
				return javaClass;
			}
		}
		return null;
	}

	@Override
	public JxJavaClass findSrcTestJavaClassByFullyQualifiedName(String fullyQualifiedName) {
		for (JxJavaClass javaClass : findAllSrcTestJavaClasses()) {
			if (javaClass.getFullyQualifiedName().equals(fullyQualifiedName)) {
				return javaClass;
			}
		}
		return null;
	}

}
