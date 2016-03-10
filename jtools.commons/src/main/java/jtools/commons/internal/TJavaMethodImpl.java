package jtools.commons.internal;

import jtools.commons.model.TJavaMethod;

import com.thoughtworks.qdox.model.JavaMethod;

public class TJavaMethodImpl implements TJavaMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 759615416847396414L;

	private JavaMethod javaMethod;

	public TJavaMethodImpl(JavaMethod javaMethod) {
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
