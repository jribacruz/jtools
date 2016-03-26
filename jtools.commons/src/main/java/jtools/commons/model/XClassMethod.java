package jtools.commons.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

/**
 * Classe que representa um método Java.
 * 
 * @author jcruz
 *
 */
public interface XClassMethod extends Serializable {

	/**
	 * Nome do método.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public JavaMethod getJavaMethod();

	/**
	 * 
	 * @return
	 */
	public boolean hasAnnotation(String name);

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object getAnnotationNamedParameter(String name, String key);

}
