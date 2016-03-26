package jtools.commons.model;

import java.io.Serializable;
import java.util.Map;

import com.thoughtworks.qdox.model.JavaField;

/**
 * Classe que representa um atributo Java.
 * 
 * @author jcruz
 *
 */
public interface XClassAttribute extends Serializable {

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

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Object getAnnotationNamedParameter(String name, String key);

	/**
	 * 
	 * @return
	 */
	public boolean isString();

	/**
	 * 
	 * @return
	 */
	public boolean isDate();

	/**
	 * 
	 * @return
	 */
	public boolean isInteger();

	/**
	 * 
	 * @return
	 */
	public boolean isLong();

	/**
	 * 
	 * @return
	 */
	public boolean isBigDecimal();

	/**
	 * 
	 * @return
	 */
	public boolean isBoolean();

	/**
	 * 
	 * @return
	 */
	public boolean isList();

	/**
	 * 
	 * @return
	 */
	public boolean isMap();

	/**
	 * 
	 * @return
	 */
	public boolean isEnum();

}
