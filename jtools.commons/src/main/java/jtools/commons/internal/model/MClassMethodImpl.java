package jtools.commons.internal.model;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;

import jtools.commons.model.MClassMethod;

public class MClassMethodImpl implements MClassMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 759615416847396414L;

	private JavaMethod javaMethod;

	public MClassMethodImpl(JavaMethod javaMethod) {
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
		return this.javaMethod;
	}

	@Override
	public boolean hasAnnotation(String name) {
		for (Annotation annotation : this.javaMethod.getAnnotations()) {
			if (annotation.getType().getValue().endsWith(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object getAnnotationNamedParameter(String name, String key) {
		for (Annotation annotation : this.javaMethod.getAnnotations()) {
			if (annotation.getType().getValue().endsWith(name)) {
				return annotation.getNamedParameter(key);
			}
		}
		return null;
	}

}
