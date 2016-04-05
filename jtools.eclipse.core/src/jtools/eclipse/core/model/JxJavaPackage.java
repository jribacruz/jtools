package jtools.eclipse.core.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaPackage;

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
	 */
	public String getPackageName();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public JxCollection<JxJavaClass> findAllClasses();

	/**
	 * 
	 * @return
	 */
	public JxJavaPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> findAllSubPackages();

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxJavaPackage findSubPackageByName(String packageName);
	
	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxJavaPackage findSubPackageByName(Predicate<JxJavaPackage> predicate);

	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public JxJavaClass findClass(Predicate<JxJavaClass> predicate);

	/**
	 * 
	 * @return
	 */
	public JavaPackage getJavaPackage();

}
