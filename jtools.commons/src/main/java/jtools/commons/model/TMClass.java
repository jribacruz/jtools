package jtools.commons.model;

import java.io.File;
import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.commons.types.TCollection;

/**
 * 
 * Modelo de classe Java.
 * 
 * @author jcruz
 *
 */
public interface TMClass extends Serializable {

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
	public TCollection<TMClassAttribute> getAttributes();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMClassMethod> getMethods();

	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasAnnotation(String name);

}
