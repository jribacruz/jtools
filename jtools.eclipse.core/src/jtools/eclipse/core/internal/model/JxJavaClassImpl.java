package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJavaClassAttribute;
import jtools.eclipse.core.model.JxJavaClassMethod;
import jtools.eclipse.core.model.JxJavaPackage;
import jtools.eclipse.core.util.JxCollection;

public class JxJavaClassImpl implements JxJavaClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5105473730117718494L;

	/**
	 * qdox JavaClass
	 */
	private JavaClass javaClass;

	/**
	 * Lista de Atributos como map.
	 */
	private JxCollection<JxJavaClassAttribute> attributes;

	/**
	 * Lista de Metodos como map.
	 */
	private JxCollection<JxJavaClassMethod> methods;

	public JxJavaClassImpl(JavaClass javaClass) {
		super();
		this.javaClass = javaClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.TClass#getName()
	 */
	@Override
	public String getName() {
		return javaClass.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.TClass#getJavaClass()
	 */
	@Override
	public JavaClass getJavaClass() {
		return this.javaClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.TClass#getFullyQualifiedName()
	 */
	@Override
	public String getFullyQualifiedName() {
		return this.javaClass.getFullyQualifiedName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.TClass#getPackageName()
	 */
	@Override
	public String getPackageName() {
		return javaClass.getPackageName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.TClass#getAttributes()
	 */
	@Override
	public JxCollection<JxJavaClassAttribute> findAllAttributes() {
		if (this.attributes == null) {
			this.attributes = new JxCollection<>();
			for (JavaField javaField : this.javaClass.getFields()) {
				this.attributes.add(new JxJavaClassAttributeImpl(javaField));
			}
		}
		return this.attributes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TClassModel#getMethods()
	 */
	@Override
	public JxCollection<JxJavaClassMethod> findAllMethods() {
		if (this.methods == null) {
			this.methods = new JxCollection<>();
			for (JavaMethod javaMethod : this.javaClass.getMethods()) {
				this.methods.add(new JxJavaClassMethodImpl(javaMethod));
			}
		}
		return this.methods;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.java.TJavaModel#hasAnnotation(java.lang.String)
	 */
	@Override
	public boolean hasAnnotation(String name) {
		for (Annotation annotation : this.javaClass.getAnnotations()) {
			if (annotation.getType().getValue().endsWith(name)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMClass#getAttributeByName(java.lang.String)
	 */
	@Override
	public JxJavaClassAttribute findAttributeByName(final String name) throws JxElementNotFoundException {
		return findAllAttributes().find(new Predicate<JxJavaClassAttribute>() {
			@Override
			public boolean apply(JxJavaClassAttribute input) {
				return input.getName().equals(name);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaClass#extendsOf(java.lang.String)
	 */
	@Override
	public boolean extendsOf(String className) {
		return javaClass.isA(className);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaClass#getParentPackage()
	 */
	@Override
	public JxJavaPackage getParentPackage() {
		return new JxJavaPackageImpl(getJavaClass().getPackage());
	}

	@Override
	public JxJavaClass getSuperClassGenericTypeArgumentByIndex(int idx) {
		return new JxJavaClassImpl(getJavaClass().getSuperClass().getActualTypeArguments()[idx].getJavaClass());
	}

	@Override
	public JxJavaClass getSuperClass() {
		return new JxJavaClassImpl(getJavaClass().getSuperClass().getJavaClass());
	}

	@Override
	public String toString() {
		return "JxJavaClassImpl [javaClass=" + javaClass.getFullyQualifiedName() + "]";
	}

}
