package jtools.eclipse.core.model.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.model.JtAttribute;
import jtools.eclipse.core.model.JtMethod;
import jtools.eclipse.core.model.JtModel;
import jtools.eclipse.core.model.JtRelationship;

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

	private String fullyQualifiedName;

	public JtModelImpl(ICompilationUnit unit) throws FileNotFoundException, IOException {
		super();
		this.compilationUnit = unit;
		JavaDocBuilder builder = new JavaDocBuilder();
		JavaSource src = builder.addSource(new File(unit.getResource().getLocation().toString()));
		this.javaClass = src.getClasses()[0];
		this.fullyQualifiedName = this.javaClass.getFullyQualifiedName();

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
				this.attributes.add(new JtAttributeImpl(this.javaClass.getFields()[i], this));
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
				this.methods.add(new JtMethodImpl(this.javaClass.getMethods()[i], this));
			}
		}
		return this.methods;
	}

	@Override
	public Annotation[] getAnnotations() {
		return this.javaClass.getAnnotations();
	}

	@Override
	public String getFullyQualifiedName() {
		return this.fullyQualifiedName;
	}

	@Override
	public String getParentPackageName() {
		return this.javaClass.getPackage().getParentPackage().getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullyQualifiedName == null) ? 0 : fullyQualifiedName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JtModelImpl other = (JtModelImpl) obj;
		if (fullyQualifiedName == null) {
			if (other.fullyQualifiedName != null)
				return false;
		} else if (!fullyQualifiedName.equals(other.fullyQualifiedName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JtModelImpl [fullyQualifiedName=" + fullyQualifiedName + "]";
	}

}
