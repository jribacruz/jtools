package jtools.generator.eclipse.ui.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;

public interface JtMethod extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public String getReturnTypeName();

	/**
	 * 
	 * @return
	 */
	public JavaMethod getJavaMethod();
	
	/**
	 * 
	 * @return
	 */
	public Annotation[] getAnnotations();
}
