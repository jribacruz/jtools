package jtools.commons.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.types.TCollection;

/**
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
	TCollection<TMClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	TCollection<TMClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	TMPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	TCollection<TMPackage> getChildPackages();
}
