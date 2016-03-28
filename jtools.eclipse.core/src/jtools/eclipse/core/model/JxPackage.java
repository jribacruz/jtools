package jtools.eclipse.core.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.XCollection;

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
	public XCollection<JxClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public XCollection<JxClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public JxPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxPackage find(String packageName);

}
