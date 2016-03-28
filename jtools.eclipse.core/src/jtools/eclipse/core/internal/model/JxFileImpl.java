package jtools.eclipse.core.internal.model;

import java.io.File;

import jtools.eclipse.core.JxCollection;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * @author jcruz
 *
 */
public class JxFileImpl implements JxFile {

	private File file;

	public JxFileImpl(File file) {
		super();
		this.file = file;
	}

	@Override
	public File getFile() {
		return this.file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#getParent()
	 */
	@Override
	public JxDir getParent() {
		return new JxDirImpl(new File(file.getParent()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#getExtension()
	 */
	@Override
	public String getExtension() {
		return FilenameUtils.getExtension(this.file.getAbsolutePath());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isJavaFile()
	 */
	@Override
	public boolean isJavaFile() {
		return getExtension().equals("java");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isCSSFile()
	 */
	@Override
	public boolean isCSSFile() {
		return getExtension().equals("css");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isJSFile()
	 */
	@Override
	public boolean isJSFile() {
		return getExtension().equals("js");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isPropertiesFile()
	 */
	@Override
	public boolean isPropertiesFile() {
		return getExtension().equals("properties");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isXMLFile()
	 */
	@Override
	public boolean isXMLFile() {
		return getExtension().equals("xml");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isHTMLFile()
	 */
	@Override
	public boolean isHTMLFile() {
		return getExtension().equals("html");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMFile#isXHTMLFile()
	 */
	@Override
	public boolean isXHTMLFile() {
		return getExtension().equals("xhtml");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.base.MFile#find(java.lang.String)
	 */
	@Override
	public JxFile find(String relativeResource) {
		String naPath = FilenameUtils.normalize(this.getFile().getAbsolutePath());
		String nrPath = FilenameUtils.normalize(relativeResource);
		return new JxFileImpl(new File(naPath + "/" + nrPath));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.base.MFile#filter(org.apache.commons.io.filefilter
	 * .IOFileFilter, org.apache.commons.io.filefilter.IOFileFilter)
	 */
	@Override
	public JxCollection<JxFile> filter(IOFileFilter fileFilter, IOFileFilter dirFilter) {
		JxCollection<JxFile> files = new JxCollection<>();
		for (File file : FileUtils.listFiles(getFile(), fileFilter, dirFilter)) {
			files.add(new JxFileImpl(file));
		}
		return files;
	}

	@Override
	public String toString() {
		return "MFileImpl [" + (file != null ? "file=" + file.getAbsolutePath() : "") + "]";
	}

}
