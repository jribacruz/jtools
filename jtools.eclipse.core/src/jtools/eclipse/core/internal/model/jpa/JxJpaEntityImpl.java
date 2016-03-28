package jtools.eclipse.core.internal.model.jpa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.internal.model.JxClassImpl;
import jtools.eclipse.core.internal.predicate.PredicateJxJpaAttributeHasAnnotation;
import jtools.eclipse.core.model.JxClassAttribute;
import jtools.eclipse.core.model.jpa.JxJpaAttribute;
import jtools.eclipse.core.model.jpa.JxJpaEntity;

/**
 * 
 * @author jcruz
 *
 */
public class JxJpaEntityImpl extends JxClassImpl implements JxJpaEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxJpaEntityImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getId()
	 */
	@Override
	public JxJpaAttribute getId() {
		return getJpaAttributes().find(new PredicateJxJpaAttributeHasAnnotation("Id"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.jpa.TMJpaEntity#isInheritance()
	 */
	@Override
	public boolean isInheritance() {
		return getJpaAttributes().find(new PredicateJxJpaAttributeHasAnnotation("Inheritance")) != null;
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
	public XCollection<JxJpaAttribute> getUniOneToMany() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public XCollection<JxJpaAttribute> getUniOneToOne() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public XCollection<JxJpaAttribute> getUniManyToOne() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public XCollection<JxJpaAttribute> getUniManyToMany() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public XCollection<JxJpaAttribute> getJpaAttributes() {
		XCollection<JxJpaAttribute> attributes = new XCollection<>();
		for (JxClassAttribute attribute : getAttributes()) {
			attributes.add(new JxJpaAttributeImpl(attribute.getJavaField()));
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
	public JxJpaAttribute getJpaAttributeByName(String name) {
		return new JxJpaAttributeImpl(this.getAttributeByName(name).getJavaField());
	}

}
