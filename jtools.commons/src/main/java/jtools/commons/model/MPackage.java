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
public interface MPackage {

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public TCollection<MClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public TCollection<MClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public MPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public TCollection<MPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public TCollection<MPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public MPackage find(String packageName);

}
