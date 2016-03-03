package jtools.core.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaField;

/**
 * 
 * @author jcruz
 *
 */
public interface JtAttribute extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public String getLabel();

	/**
	 * 
	 * @return
	 */
	public String getTypeName();

	/**
	 * 
	 * @return
	 */
	public Annotation[] getAnnotations();

	/**
	 * 
	 * @return
	 */
	public JavaField getJavaField();

	/**
	 * 
	 * @return
	 */
	public boolean getColumnLength();

	/**
	 * 
	 * @return
	 */
	public int getColumnPrecision();

	/**
	 * 
	 * @return
	 */
	public int getColumnScale();

	/**
	 * 
	 * @return
	 */
	public boolean isRelationship();

	/**
	 * 
	 * @return
	 */
	public boolean isId();

	/**
	 * 
	 * @return
	 */
	public boolean isString();

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
	public boolean isInteger();

	/**
	 * 
	 * @return
	 */
	public boolean isRequired();

	/**
	 * 
	 * @return
	 */
	public boolean isDate();

	/**
	 * 
	 * @return
	 */
	public boolean isTime();

	/**
	 * 
	 * @return
	 */
	public boolean isTimestamp();

	/**
	 * 
	 * @return
	 */
	public boolean isEnum();

	/**
	 * 
	 * @return
	 */
	public boolean isTransient();

	/**
	 * 
	 * @return
	 */
	public boolean isStatic();

	/**
	 * 
	 * @return
	 */
	public List<String> getSortBy();
	
	/**
	 * 
	 * @return
	 */
	public JtModel getParentModel();
}
