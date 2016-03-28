package jtools.eclipse.core.internal.model;

import java.util.HashMap;
import java.util.Map;

import jtools.eclipse.core.model.JxClassAttribute;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;

public class JxClassAttributeImpl implements JxClassAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6299511676333490782L;

	private JavaField javaField;

	public JxClassAttributeImpl(JavaField javaField) {
		super();
		this.javaField = javaField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#getName()
	 */
	@Override
	public String getName() {
		return javaField.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#getType()
	 */
	@Override
	public String getType() {
		return javaField.getType().getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#getGenericType()
	 */
	@Override
	public Map<Integer, String> getGenericType() {
		Map<Integer, String> genericTypes = new HashMap<>();
		if (isGenericType()) {
			for (int i = 0; i < javaField.getType().getActualTypeArguments().length; i++) {
				String type = javaField.getType().getActualTypeArguments()[i].getValue();
				genericTypes.put(i, type);
			}
		}
		return genericTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#isGenericType()
	 */
	@Override
	public boolean isGenericType() {
		return javaField.getType().getActualTypeArguments() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#hasSetter()
	 */
	@Override
	public boolean hasSetter() {
		String nameWithFirstCharUpper = getNameWithFirstCharUpper();
		String setterName = "set" + nameWithFirstCharUpper;
		for (JavaMethod method : javaField.getParentClass().getMethods()) {
			if (method.getName().equals(setterName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TAttribute#hasGetter()
	 */
	@Override
	public boolean hasGetter() {
		String nameWithFirstCharUpper = getNameWithFirstCharUpper();
		String setterName = "get" + nameWithFirstCharUpper;
		for (JavaMethod method : javaField.getParentClass().getMethods()) {
			if (method.getName().equals(setterName)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TJavaAttribute#getJavaField()
	 */
	@Override
	public JavaField getJavaField() {
		return this.javaField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.TMClassAttribute#hasAnnotation(java.lang.String)
	 */
	@Override
	public boolean hasAnnotation(String name) {
		for (Annotation annotation : this.javaField.getAnnotations()) {
			if (annotation.getType().getValue().endsWith(name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object getAnnotationNamedParameter(String name, String key) {
		for (Annotation annotation : this.javaField.getAnnotations()) {
			if (annotation.getType().getValue().endsWith(name)) {
				return annotation.getNamedParameter(key);
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isString()
	 */
	@Override
	public boolean isString() {
		return getType().endsWith("String");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isDate()
	 */
	@Override
	public boolean isDate() {
		return getType().endsWith("Date");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isInteger()
	 */
	@Override
	public boolean isInteger() {
		return getType().endsWith("IntegerF");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isLong()
	 */
	@Override
	public boolean isLong() {
		return getType().endsWith("Long");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isBigDecimal()
	 */
	@Override
	public boolean isBigDecimal() {
		return getType().endsWith("BigDecimal");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isBoolean()
	 */
	@Override
	public boolean isBoolean() {
		return getType().endsWith("Boolean");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isList()
	 */
	@Override
	public boolean isList() {
		return getType().endsWith("List");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClassAttribute#isMap()
	 */
	@Override
	public boolean isMap() {
		return getType().endsWith("Map");
	}

	@Override
	public boolean isEnum() {
		return false;
	}

	private String getNameWithFirstCharUpper() {
		String nameWithFirstCharUpper = Character.toUpperCase(getName().charAt(0)) + getName().substring(1, getName().length());
		return nameWithFirstCharUpper;
	}

}
