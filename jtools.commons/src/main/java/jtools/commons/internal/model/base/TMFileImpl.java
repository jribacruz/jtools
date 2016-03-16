package jtools.commons.internal.model.base;

import java.io.File;

import jtools.commons.model.base.TMDir;
import jtools.commons.model.base.TMFile;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @author jcruz
 *
 */
public class TMFileImpl implements TMFile {

	private File file;

	public TMFileImpl(File file) {
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
	public TMDir getParent() {
		return new TMDirImpl(new File(file.getParent()));
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
