package jtools.commons.internal.model;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import jtools.commons.model.TMDir;
import jtools.commons.model.TMFile;

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

	@Override
	public TMDir getParent() {
		return new TMDirImpl(new File(file.getParent()));
	}

	@Override
	public String getExtension() {
		return FilenameUtils.getExtension(this.file.getAbsolutePath());
	}

	@Override
	public boolean isJavaFile() {
		return getExtension().equals("java");
	}

	@Override
	public boolean isCSSFile() {
		return getExtension().equals("css");
	}

	@Override
	public boolean isJSFile() {
		return getExtension().equals("js");
	}

	@Override
	public boolean isPropertiesFile() {
		return getExtension().equals("properties");
	}

	@Override
	public boolean isXMLFile() {
		return getExtension().equals("xml");
	}

	@Override
	public boolean isHTMLFile() {
		return getExtension().equals("html");
	}

	@Override
	public boolean isXHTMLFile() {
		return getExtension().equals("xhtml");
	}

}
