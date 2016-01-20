package jtools.generator.eclipse.ui.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.model.Attribute;
import jtools.generator.eclipse.ui.model.Model;
import jtools.generator.eclipse.ui.model.Relationship;

import org.eclipse.jdt.core.ICompilationUnit;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;

public class ModelImpl implements Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaClass javaClass;

	private List<Relationship> relationships;

	private List<Attribute> attributes;

	public ModelImpl(ICompilationUnit unit) throws FileNotFoundException, IOException {
		super();
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
	public List<Relationship> getRelationships() {
		if (this.relationships == null) {
			this.relationships = new ArrayList<>();
		}
		return relationships;
	}

	@Override
	public List<Attribute> getAttributes() {
		if (this.attributes == null) {
			this.attributes = new ArrayList<>();
			for (int i = 0; i < javaClass.getFields().length; i++) {
				this.attributes.add(new AttributeImpl(this.javaClass.getFields()[i]));
			}
		}
		return this.attributes;
	}

}
