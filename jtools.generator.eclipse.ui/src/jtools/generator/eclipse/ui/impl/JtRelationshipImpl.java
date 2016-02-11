package jtools.generator.eclipse.ui.impl;

import jtools.generator.eclipse.ui.model.JtModel;
import jtools.generator.eclipse.ui.model.JtRelationship;

import com.thoughtworks.qdox.model.JavaField;

/**
 * 
 * @author jcruz
 *
 */
public class JtRelationshipImpl implements JtRelationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaField javaField;

	private JtModel parentModel;

	public JtRelationshipImpl(JavaField javaField, JtModel parentModel) {
		super();
		this.javaField = javaField;
		this.parentModel = parentModel;
	}

	@Override
	public boolean isComposition() {
		return false;
	}

	@Override
	public boolean isOneToMany() {
		return false;
	}

	@Override
	public boolean isManyToOne() {
		return false;
	}

	@Override
	public boolean isManyToMany() {
		return false;
	}

	@Override
	public boolean isOneToOne() {
		return false;
	}

	@Override
	public JtModel getParentModel() {
		return this.parentModel;
	}

}
