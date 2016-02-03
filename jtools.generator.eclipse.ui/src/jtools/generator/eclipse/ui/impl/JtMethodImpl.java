package jtools.generator.eclipse.ui.impl;

import jtools.generator.eclipse.ui.model.JtMethod;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;

public class JtMethodImpl implements JtMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaMethod javaMethod;

	public JtMethodImpl(JavaMethod javaMethod) {
		super();
		this.javaMethod = javaMethod;
	}

	@Override
	public String getName() {
		return javaMethod.getName();
	}

	@Override
	public String getReturnTypeName() {
		return null;
	}

	@Override
	public JavaMethod getJavaMethod() {
		return this.javaMethod;
	}

	@Override
	public Annotation[] getAnnotations() {
		return this.javaMethod.getAnnotations();
	}

}
