package jtools.commons.model;

import java.io.File;

/**
 * 
 * @author jcruz
 *
 */
public interface TMFile {

	/**
	 * 
	 * @return
	 */
	public File getFile();

	/**
	 * 
	 * @return
	 */
	public TMDir getParent();

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

}
