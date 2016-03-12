package jtools.commons.model;

import java.io.Serializable;
import java.util.Map;

import com.thoughtworks.qdox.model.JavaField;

/**
 * Modelo de atributo Java.
 * 
 * @author jcruz
 *
 */
public interface TMJavaAttribute extends Serializable {

	/**
	 * 
	 * @return
	 */
	public JavaField getJavaField();

	/**
	 * Nome do atributo.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public String getType();

	/**
	 * 
	 * @return
	 */
	public Map<Integer, String> getGenericType();

	/**
	 * 
	 * @return
	 */
	public boolean isGenericType();

	/**
	 * 
	 * @return
	 */
	public boolean hasSetter();

	/**
	 * 
	 * @return
	 */
	public boolean hasGetter();

	/**
	 * 
	 * @return
	 */
	public boolean hasAnnotation(String name);

}
