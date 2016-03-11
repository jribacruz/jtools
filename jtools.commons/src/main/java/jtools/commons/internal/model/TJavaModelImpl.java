package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.model.java.TJavaAttribute;
import jtools.commons.model.java.TJavaMethod;
import jtools.commons.model.java.TJavaModel;
import jtools.commons.types.TJavaAttributeCollection;
import jtools.commons.types.TJavaMethodCollection;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaSource;

public class TJavaModelImpl implements TJavaModel {

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
	private TJavaAttributeCollection<TJavaAttribute> attributes;

	/**
	 * Lista de Metodos como map.
	 */
	private TJavaMethodCollection<TJavaMethod> methods;

	public TJavaModelImpl(File javaFile) throws FileNotFoundException, IOException {
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
	public TJavaAttributeCollection<TJavaAttribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new TJavaAttributeCollection<>();
			for (JavaField javaField : this.javaClass.getFields()) {
				this.attributes.add(new TJavaAttributeImpl(javaField));
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
	public TJavaMethodCollection<TJavaMethod> getMethods() {
		if (this.methods == null) {
			this.methods = new TJavaMethodCollection<>();
			for (JavaMethod javaMethod : this.javaClass.getMethods()) {
				this.methods.add(new TJavaMethodImpl(javaMethod));
			}
		}
		return this.methods;
	}

}
