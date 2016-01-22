package jtools.generator.eclipse.ui.impl;

import java.util.List;

import jtools.generator.eclipse.ui.model.Attribute;

import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaField;

public class AttributeImpl implements Attribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaField javaField;

	public AttributeImpl(JavaField javaField) {
		super();
		this.javaField = javaField;
	}

	@Override
	public String getName() {
		return javaField.getName();
	}

	@Override
	public String getLabel() {
		DocletTag tag = javaField.getTagByName("label");
		if (tag != null) {
			return tag.getValue();
		}
		return null;
	}

	@Override
	public String getTypeName() {
		return null;
	}

	@Override
	public JavaField getJavaField() {
		return this.javaField;
	}

	@Override
	public boolean getColumnLength() {
		return false;
	}

	@Override
	public int getColumnPrecision() {
		return 0;
	}

	@Override
	public int getColumnScale() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRelationship() {
		return false;
	}

	@Override
	public boolean isId() {
		return false;
	}

	@Override
	public boolean isString() {
		return false;
	}

	@Override
	public boolean isLong() {
		return false;
	}

	@Override
	public boolean isBigDecimal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBoolean() {
		return false;
	}

	@Override
	public boolean isInteger() {
		return false;
	}

	@Override
	public boolean isRequired() {
		return false;
	}

	@Override
	public boolean isDate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTime() {
		return false;
	}

	@Override
	public boolean isTimestamp() {
		return false;
	}

	@Override
	public boolean isEnum() {
		return false;
	}

	@Override
	public boolean isTransient() {
		return false;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public List<String> getSortBy() {
		return null;
	}

}