package jtools.eclipse.core.model;

import java.io.File;
import java.io.Serializable;

import jtools.eclipse.core.JxCollection;

import com.thoughtworks.qdox.model.JavaClass;

/**
 * 
 * Classe que representa uma classe Java.
 * 
 * @author jcruz
 *
 */
public interface JxClass extends Serializable {

	/**
	 * Nome simples (sem o nome do package) da classe.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Arquivo da classe Java.
	 * 
	 * @return
	 */
	public File getFile();

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
	 * Mapa com os atributos da classe.
	 * 
	 * @return Map com os atributos. key - Nome do Atributo value - TAttribute
	 */
	public JxCollection<JxClassAttribute> getAttributes();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxClassMethod> getMethods();

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
	public JxClassAttribute getAttributeByName(String name);

	/**
	 * 
	 * @param className
	 * @return
	 */
	public boolean extendsOf(String className);

}
