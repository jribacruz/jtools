package jtools.eclipse.core.model;

import java.io.FileNotFoundException;
import java.io.IOException;

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
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public JxCollection<JxJavaClass> findAllChildClasses();

	/**
	 * 
	 * @param recursively
	 * @return
	 */
	public JxCollection<JxJavaClass> findAllChildClasses(boolean recursively);

	/**
	 * 
	 * @return
	 */
	public JxJavaPackage getParentPackage();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> findAllChildPackages();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaPackage> findAllChildPackages(boolean recursively);

	/**
	 * 
	 * @param packageName
	 * @return
	 */
	public JxJavaPackage find(String packageName);

	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public JxJavaClass findChildClass(Predicate<JxJavaClass> predicate);

	/**
	 * 
	 * @return
	 */
	public JavaPackage getJavaPackage();

}
