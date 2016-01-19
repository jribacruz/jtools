package jtools.generator.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.JavaField;

public interface Attribute extends Serializable {

	public String getName();

	public String getLabel();

	public String getTypeName();

	public JavaField getJavaField();

	public boolean getColumnLength();

	public int getColumnPrecision();

	public int getColumnScale();

	public boolean isRelationship();

	public boolean isId();

	public boolean isString();

	public boolean isLong();

	public boolean isBigDecimal();

	public boolean isBoolean();

	public boolean isInteger();

	public boolean isRequired();

	public boolean isDate();

	public boolean isTime();

	public boolean isTimestamp();

	public boolean isEnum();

	public boolean isTransient();

	public boolean isStatic();

	public List<String> getSortBy();
}
