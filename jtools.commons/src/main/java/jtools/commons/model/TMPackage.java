package jtools.commons.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.types.TCollection;

/**
 * Classe que representa um pacote Java.
 * 
 * @author jcruz
 *
 */
public interface TMPackage {

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public TCollection<TMClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public TCollection<TMClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public TMPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public TMPackage find(String packageName);

}
