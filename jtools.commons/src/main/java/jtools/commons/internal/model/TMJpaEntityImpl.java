package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import jtools.commons.model.TMClassAttribute;
import jtools.commons.model.TMJpaAttribute;
import jtools.commons.model.TMJpaEntity;
import jtools.commons.predicate.TMJpaAttributeAnnotationPredicate;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMJpaEntityImpl extends TMClassImpl implements TMJpaEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TMJpaEntityImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getId()
	 */
	@Override
	public TMJpaAttribute getId() {
		return getJpaAttributes().find(new TMJpaAttributeAnnotationPredicate("Id"));
	}

	@Override
	public boolean isInheritance() {
		return getJpaAttributes().find(new TMJpaAttributeAnnotationPredicate("Inheritance")) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getTableName()
	 */
	@Override
	public String getTableName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getOneToManyRelationships()
	 */
	@Override
	public TCollection<TMJpaAttribute> getUniOneToMany() {
		return getJpaAttributes().filter(new TMJpaAttributeAnnotationPredicate("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public TCollection<TMJpaAttribute> getUniOneToOne() {
		return getJpaAttributes().filter(new TMJpaAttributeAnnotationPredicate("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public TCollection<TMJpaAttribute> getUniManyToOne() {
		return getJpaAttributes().filter(new TMJpaAttributeAnnotationPredicate("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public TCollection<TMJpaAttribute> getUniManyToMany() {
		return getJpaAttributes().filter(new TMJpaAttributeAnnotationPredicate("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public TCollection<TMJpaAttribute> getJpaAttributes() {
		TCollection<TMJpaAttribute> attributes = new TCollection<>();
		for (TMClassAttribute attribute : getAttributes()) {
			attributes.add(new TMJpaAttributeImpl(attribute.getJavaField()));
		}
		return attributes;
	}

}
