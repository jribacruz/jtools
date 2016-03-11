package jtools.commons.model.java;

import java.io.File;
import java.io.Serializable;

import jtools.commons.types.TJavaAttributeCollection;
import jtools.commons.types.TJavaMethodCollection;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.thoughtworks.qdox.model.JavaClass;

/**
 * 
 * Classe que representa uma classe Java.
 * 
 * @author jcruz
 *
 */
public interface TJavaModel extends Serializable {

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
	 * Object roaster JavaClassSource
	 * 
	 * @return
	 */
	public JavaClassSource getJavaClassSource();

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
	public TJavaAttributeCollection<TJavaAttribute> getAttributes();

	/**
	 * 
	 * @return
	 */
	public TJavaMethodCollection<TJavaMethod> getMethods();

}
