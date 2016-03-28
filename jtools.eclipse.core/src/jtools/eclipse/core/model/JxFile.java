package jtools.eclipse.core.model;

import java.io.File;

import jtools.eclipse.core.util.JxCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * Classe que representa um arquivo.
 * 
 * @author jcruz
 *
 */
public interface JxFile {

	/**
	 * 
	 * @return
	 */
	public File getFile();

	/**
	 * 
	 * @return
	 */
	public JxDir getParent();

	/**
	 * 
	 * @return
	 */
	public String getExtension();

	/**
	 * 
	 * @return
	 */
	public boolean isJavaFile();

	/**
	 * 
	 * @return
	 */
	public boolean isCSSFile();

	/**
	 * 
	 * @return
	 */
	public boolean isJSFile();

	/**
	 * 
	 * @return
	 */
	public boolean isPropertiesFile();

	/**
	 * 
	 * @return
	 */
	public boolean isXMLFile();

	/**
	 * 
	 * @return
	 */
	public boolean isHTMLFile();

	/**
	 * 
	 * @return
	 */
	public boolean isXHTMLFile();

	/**
	 * 
	 * @param resource
	 * @return
	 */
	public JxFile find(String resource);

	/**
	 * 
	 * @param fileFilter
	 * @param dirFileFilter
	 * @return
	 */
	public JxCollection<JxFile> filter(IOFileFilter fileFilter, IOFileFilter dirFileFilter);

}
