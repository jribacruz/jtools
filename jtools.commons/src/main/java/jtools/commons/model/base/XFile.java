package jtools.commons.model.base;

import java.io.File;

import jtools.commons.types.XCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * 
 * Classe que representa um arquivo.
 * 
 * @author jcruz
 *
 */
public interface XFile {

	/**
	 * 
	 * @return
	 */
	public File getFile();

	/**
	 * 
	 * @return
	 */
	public XDir getParent();

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
	public XFile find(String resource);

	/**
	 * 
	 * @param fileFilter
	 * @param dirFileFilter
	 * @return
	 */
	public XCollection<XFile> filter(IOFileFilter fileFilter, IOFileFilter dirFileFilter);

}
