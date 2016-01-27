package jtools.generator.eclipse.ui.impl;

import com.thoughtworks.qdox.model.JavaField;

import jtools.generator.eclipse.ui.model.Relationship;

/**
 * 
 * @author jcruz
 *
 */
public class RelationshipImpl implements Relationship {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaField javaField;

	public RelationshipImpl(JavaField javaField) {
		super();
		this.javaField = javaField;
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

}
