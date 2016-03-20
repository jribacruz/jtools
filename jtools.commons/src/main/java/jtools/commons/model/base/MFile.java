package jtools.commons.model.base;

import java.io.File;

import jtools.commons.types.TCollection;

import org.apache.commons.io.filefilter.IOFileFilter;

import com.google.common.base.Function;

/**
 * 
 * Classe que representa um arquivo.
 * 
 * @author jcruz
 *
 */
public interface MFile {

	/**
	 * 
	 * @return
	 */
	public File getFile();

	/**
	 * 
	 * @return
	 */
	public MDir getParent();

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
	public MFile find(String resource);

	/**
	 * 
	 * @param fileFilter
	 * @param dirFileFilter
	 * @return
	 */
	public TCollection<MFile> filter(IOFileFilter fileFilter, IOFileFilter dirFileFilter);

}
