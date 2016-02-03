package jtools.generator.eclipse.ui.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.model.JtAttribute;
import jtools.generator.eclipse.ui.model.JtMethod;
import jtools.generator.eclipse.ui.model.JtModel;
import jtools.generator.eclipse.ui.model.JtRelationship;

import org.eclipse.jdt.core.ICompilationUnit;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

public class JtModelImpl implements JtModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaClass javaClass;

	private List<JtRelationship> relationships;

	private List<JtAttribute> attributes;

	private List<JtMethod> methods;

	private ICompilationUnit compilationUnit;

	public JtModelImpl(ICompilationUnit unit) throws FileNotFoundException, IOException {
		super();
		this.compilationUnit = unit;
		JavaDocBuilder builder = new JavaDocBuilder();
		JavaSource src = builder.addSource(new File(unit.getResource().getLocation().toString()));
		this.javaClass = src.getClasses()[0];
	}

	@Override
	public String getPackageName() {
		return javaClass.getPackageName();
	}

	@Override
	public String getName() {
		return javaClass.getName();
	}

	@Override
	public List<JtRelationship> getRelationships() {
		if (this.relationships == null) {
			this.relationships = new ArrayList<>();
		}
		return relationships;
	}

	@Override
	public List<JtAttribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new ArrayList<>();
			for (int i = 0; i < javaClass.getFields().length; i++) {
				this.attributes.add(new JtAttributeImpl(this.javaClass.getFields()[i]));
			}
		}
		return this.attributes;
	}

	@Override
	public ICompilationUnit getCompilationUnit() {
		return this.compilationUnit;
	}

	@Override
	public JavaClass getJavaClass() {
		return this.javaClass;
	}

	@Override
	public List<JtMethod> getMethods() {
		if (this.methods == null) {
			this.methods = new ArrayList<>();
			for (int i = 0; i < javaClass.getMethods().length; i++) {
				this.methods.add(new JtMethodImpl(this.javaClass.getMethods()[i]));
			}
		}
		return null;
	}

	@Override
	public Annotation[] getAnnotations() {
		return this.javaClass.getAnnotations();
	}

}