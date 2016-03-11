package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaSource;

import jtools.commons.model.TMJavaAttribute;
import jtools.commons.model.TMJavaMethod;
import jtools.commons.model.TMJava;
import jtools.commons.types.TCollection;

public class TMJavaImpl implements TMJava {

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
	 * roaster JavaClassSource
	 */
	private JavaClassSource javaClassSource;

	/**
	 * Lista de Atributos como map.
	 */
	private TCollection<TMJavaAttribute> attributes;

	/**
	 * Lista de Metodos como map.
	 */
	private TCollection<TMJavaMethod> methods;

	public TMJavaImpl(File javaFile) throws FileNotFoundException, IOException {
		super();
		this.javaFile = javaFile;
		JavaDocBuilder builder = new JavaDocBuilder();
		JavaSource source = builder.addSource(javaFile);
		this.javaClass = source.getClasses()[0];
		this.javaClassSource = Roaster.parse(JavaClassSource.class, javaFile);
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
	public TCollection<TMJavaAttribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new TCollection<>();
			for (JavaField javaField : this.javaClass.getFields()) {
				this.attributes.add(new TMJavaAttributeImpl(javaField));
			}
		}
		return this.attributes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TClassModel#getJavaClassSource()
	 */
	@Override
	public JavaClassSource getJavaClassSource() {
		return this.javaClassSource;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see tools4j.model.core.TClassModel#getMethods()
	 */
	@Override
	public TCollection<TMJavaMethod> getMethods() {
		if (this.methods == null) {
			this.methods = new TCollection<>();
			for (JavaMethod javaMethod : this.javaClass.getMethods()) {
				this.methods.add(new TMJavaMethodImpl(javaMethod));
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

}
