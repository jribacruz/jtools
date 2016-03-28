package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxClassAttribute;
import jtools.eclipse.core.model.JxClassMethod;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaSource;

public class JxClassImpl implements JxClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5105473730117718494L;

	private File javaFile;

	/**
	 * qdox JavaClass
	 */
	private JavaClass javaClass;

	/**
	 * Lista de Atributos como map.
	 */
	private XCollection<JxClassAttribute> attributes;

	/**
	 * Lista de Metodos como map.
	 */
	private XCollection<JxClassMethod> methods;

	public JxClassImpl(File javaFile) throws FileNotFoundException, IOException {
		super();
		this.javaFile = javaFile;
		JavaDocBuilder builder = new JavaDocBuilder();
		JavaSource source = builder.addSource(javaFile);
		this.javaClass = source.getClasses()[0];
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
	 * @see tools4j.model.TClass#getFile()
	 */
	@Override
	public File getFile() {
		return this.javaFile;
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
	public XCollection<JxClassAttribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new XCollection<>();
			for (JavaField javaField : this.javaClass.getFields()) {
				this.attributes.add(new JxClassAttributeImpl(javaField));
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
	public XCollection<JxClassMethod> getMethods() {
		if (this.methods == null) {
			this.methods = new XCollection<>();
			for (JavaMethod javaMethod : this.javaClass.getMethods()) {
				this.methods.add(new JxClassMethodImpl(javaMethod));
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
	public JxClassAttribute getAttributeByName(final String name) {
		return getAttributes().find(new Predicate<JxClassAttribute>() {
			@Override
			public boolean apply(JxClassAttribute input) {
				return input.getName().equals(name);
			}
		});
	}

	@Override
	public boolean extendsOf(String className) {
		return javaClass.isA(className);
	}

	@Override
	public String toString() {
		return "TMClassImpl [javaFile=" + javaFile.getName() + "]";
	}

}
