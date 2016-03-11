package jtools.commons.model.java;

import java.io.Serializable;
import java.util.Map;

import com.thoughtworks.qdox.model.JavaField;

/**
 * Classe que representa um attributo de uma classe Java.
 * 
 * @author jcruz
 *
 */
public interface TJavaAttribute extends Serializable {

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

}
