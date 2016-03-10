package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jtools.commons.model.TJavaAttribute;
import jtools.commons.model.TJavaModel;
import jtools.commons.model.TJavaMethod;

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
	private Map<String, TJavaAttribute> attributes;

	/**
	 * Lista de Metodos como map.
	 */
	private Map<String, TJavaMethod> methods;

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
	public Map<String, TJavaAttribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new HashMap<>();
			for (JavaField javaField : this.javaClass.getFields()) {
				this.attributes.put(javaField.getName(), new TJavaAttributeImpl(javaField));
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
	public Map<String, TJavaMethod> getMethods() {
		if (this.methods == null) {
			this.methods = new HashMap<>();
			for (JavaMethod javaMethod : this.javaClass.getMethods()) {
				this.methods.put(javaMethod.getName(), new TJavaMethodImpl(javaMethod));
			}
		}
		return this.methods;
	}

}
