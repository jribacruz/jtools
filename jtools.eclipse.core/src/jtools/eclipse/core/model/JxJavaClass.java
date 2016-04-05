package jtools.eclipse.core.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.util.JxCollection;

/**
 * 
 * Classe que representa uma classe Java.
 * 
 * @author jcruz
 *
 */
public interface JxJavaClass extends Serializable {

	/**
	 * Nome simples (sem o nome do package) da classe.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Objeto qdox JavaClass.
	 * 
	 * @return
	 */
	public JavaClass getJavaClass();

	/**
	 * 
	 * Nome da classe mais o package.
	 * 
	 * @return
	 */
	public String getFullyQualifiedName();

	/**
	 * 
	 * Nome do package
	 * 
	 * @return
	 */
	public String getPackageName();

	/**
	 * 
	 * @return
	 */
	public JxJavaPackage getParentPackage();

	/**
	 * Mapa com os atributos da classe.
	 * 
	 * @return Map com os atributos. key - Nome do Atributo value - TAttribute
	 */
	public JxCollection<JxJavaClassAttribute> findAllAttributes();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClassMethod> findAllMethods();

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasAnnotation(String name);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public JxJavaClassAttribute findAttributeByName(String name);

	/**
	 * 
	 * @param className
	 * @return
	 */
	public boolean extendsOf(String className);

	/**
	 * 
	 * @param idx
	 * @return
	 */
	public JxJavaClass getGenericTypeArgument(int idx);

	/**
	 * 
	 * @return
	 */
	public JxJavaClass getSuperClass();

}
