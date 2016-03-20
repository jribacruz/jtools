package jtools.commons.internal.model.jpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MClassImpl;
import jtools.commons.model.MClassAttribute;
import jtools.commons.model.jpa.MJpaAttribute;
import jtools.commons.model.jpa.MJpaEntity;
import jtools.commons.predicate.PredicateMJpaAttributeAnnotation;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MJpaEntityImpl extends MClassImpl implements MJpaEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MJpaEntityImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getId()
	 */
	@Override
	public MJpaAttribute getId() {
		return getJpaAttributes().find(new PredicateMJpaAttributeAnnotation("Id"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.jpa.TMJpaEntity#isInheritance()
	 */
	@Override
	public boolean isInheritance() {
		return getJpaAttributes().find(new PredicateMJpaAttributeAnnotation("Inheritance")) != null;
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
	public TCollection<MJpaAttribute> getUniOneToMany() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeAnnotation("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public TCollection<MJpaAttribute> getUniOneToOne() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeAnnotation("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public TCollection<MJpaAttribute> getUniManyToOne() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeAnnotation("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public TCollection<MJpaAttribute> getUniManyToMany() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeAnnotation("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public TCollection<MJpaAttribute> getJpaAttributes() {
		TCollection<MJpaAttribute> attributes = new TCollection<>();
		for (MClassAttribute attribute : getAttributes()) {
			attributes.add(new MJpaAttributeImpl(attribute.getJavaField()));
		}
		return attributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.jpa.TMJpaEntity#getJpaAttributeByName(java.lang.
	 * String)
	 */
	@Override
	public MJpaAttribute getJpaAttributeByName(String name) {
		return new MJpaAttributeImpl(this.getAttributeByName(name).getJavaField());
	}

}
