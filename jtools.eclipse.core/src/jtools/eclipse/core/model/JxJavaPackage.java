package jtools.eclipse.core.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.util.JxCollection;

/**
 * Classe que representa um pacote Java.
 * 
 * @author jcruz
 *
 */
public interface JxJavaPackage {
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public JxCollection<JxJavaClass> getClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public JxCollection<JxJavaClass> getClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public JxJavaPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> getChildPackages();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> getChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxJavaPackage find(String packageName);

}
