package jtools.commons.internal.model;

import com.thoughtworks.qdox.model.JavaMethod;

import jtools.commons.model.TMJavaMethod;

public class TMJavaMethodImpl implements TMJavaMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 759615416847396414L;

	private JavaMethod javaMethod;

	public TMJavaMethodImpl(JavaMethod javaMethod) {
		super();
		this.javaMethod = javaMethod;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TJavaMethod#getName()
	 */
	@Override
	public String getName() {
		return this.javaMethod.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TJavaMethod#getJavaMethod()
	 */
	@Override
	public JavaMethod getJavaMethod() {
		return null;
	}

}