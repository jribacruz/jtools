package jtools.commons.internal.model.jpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MClassImpl;
import jtools.commons.model.XClassAttribute;
import jtools.commons.model.jpa.XJpaAttribute;
import jtools.commons.model.jpa.XJpaEntity;
import jtools.commons.predicate.PredicateMJpaAttributeHasAnnotation;
import jtools.commons.types.XCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MJpaEntityImpl extends MClassImpl implements XJpaEntity {
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
	public XJpaAttribute getId() {
		return getJpaAttributes().find(new PredicateMJpaAttributeHasAnnotation("Id"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.jpa.TMJpaEntity#isInheritance()
	 */
	@Override
	public boolean isInheritance() {
		return getJpaAttributes().find(new PredicateMJpaAttributeHasAnnotation("Inheritance")) != null;
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
	public XCollection<XJpaAttribute> getUniOneToMany() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeHasAnnotation("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public XCollection<XJpaAttribute> getUniOneToOne() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeHasAnnotation("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public XCollection<XJpaAttribute> getUniManyToOne() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeHasAnnotation("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public XCollection<XJpaAttribute> getUniManyToMany() {
		return getJpaAttributes().filter(new PredicateMJpaAttributeHasAnnotation("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public XCollection<XJpaAttribute> getJpaAttributes() {
		XCollection<XJpaAttribute> attributes = new XCollection<>();
		for (XClassAttribute attribute : getAttributes()) {
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
	public XJpaAttribute getJpaAttributeByName(String name) {
		return new MJpaAttributeImpl(this.getAttributeByName(name).getJavaField());
	}

}
