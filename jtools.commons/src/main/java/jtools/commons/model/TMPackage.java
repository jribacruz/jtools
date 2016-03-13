package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface TMPackage extends TMDir {

	/**
	 * 
	 * @return
	 */
	TCollection<TMClass> getClasses();

	/**
	 * 
	 * @return
	 */
	TMPackage getParent();

	/**
	 * 
	 * @return
	 */
	TCollection<TMPackage> getChildPackages();
}
