package jtools.commons.internal.model.base;

import java.io.File;

import jtools.commons.model.base.MDir;
import jtools.commons.model.base.MFile;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @author jcruz
 *
 */
public class MFileImpl implements MFile {

	private File file;

	public MFileImpl(File file) {
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
	public MDir getParent() {
		return new MDirImpl(new File(file.getParent()));
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

}
