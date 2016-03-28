package jtools.eclipse.core.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.JxCollection;

/**
 * Classe que representa um pacote Java.
 * 
 * @author jcruz
 *
 */
public interface JxPackage {
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public JxCollection<JxClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public JxCollection<JxClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public JxPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxPackage find(String packageName);

}
