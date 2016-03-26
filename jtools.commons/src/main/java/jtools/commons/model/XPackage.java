package jtools.commons.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.types.XCollection;

/**
 * Classe que representa um pacote Java.
 * 
 * @author jcruz
 *
 */
public interface XPackage {
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public XCollection<XClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public XCollection<XClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public XPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public XCollection<XPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<XPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public XPackage find(String packageName);

}
