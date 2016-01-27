package jtools.generator.eclipse.ui.impl;

import jtools.generator.eclipse.ui.model.Method;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;

public class MethodImpl implements Method {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaMethod javaMethod;

	public MethodImpl(JavaMethod javaMethod) {
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
