package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.internal.model.predicate.PredicateJxJpaAttributeHasAnnotation;
import jtools.eclipse.core.model.JxJavaClassAttribute;
import jtools.eclipse.core.model.JxJpaAttribute;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.util.JxCollection;

/**
 * 
 * @author jcruz
 *
 */
public class JxJpaEntityImpl extends JxJavaClassImpl implements JxJpaEntity {
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
	public JxCollection<JxJpaAttribute> getUniOneToMany() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniOneToOne() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniManyToOne() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniManyToMany() {
		return getJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getJpaAttributes() {
		JxCollection<JxJpaAttribute> attributes = new JxCollection<>();
		for (JxJavaClassAttribute attribute : getAttributes()) {
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
