package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.internal.model.predicate.PredicateJxJpaAttributeHasAnnotation;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJavaClassAttribute;
import jtools.eclipse.core.model.JxJpaAttribute;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.model.JxMavenProject;
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

	private JxMavenProject mavenProject;

	public JxJpaEntityImpl(JxMavenProject mavenProject, JavaClass javaClass) {
		super(javaClass);
		this.mavenProject = mavenProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getId()
	 */
	@Override
	public JxJpaAttribute getId() throws JxElementNotFoundException {
		return findAllJpaAttributes().find(new PredicateJxJpaAttributeHasAnnotation("Id"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.jpa.TMJpaEntity#isInheritance()
	 */
	@Override
	public boolean isInheritance() throws JxElementNotFoundException {
		return hasAnnotation("Inheritance");
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
		return findAllJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniOneToOne()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniOneToOne() {
		return findAllJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("OneToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToOne()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniManyToOne() {
		return findAllJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToOne"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getUniManyToMany()
	 */
	@Override
	public JxCollection<JxJpaAttribute> getUniManyToMany() {
		return findAllJpaAttributes().filter(new PredicateJxJpaAttributeHasAnnotation("ManyToMany"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaEntity#getJpaAttributes()
	 */
	@Override
	public JxCollection<JxJpaAttribute> findAllJpaAttributes() {
		JxCollection<JxJpaAttribute> attributes = new JxCollection<>();
		for (JxJavaClassAttribute attribute : findAllAttributes()) {
			attributes.add(new JxJpaAttributeImpl(attribute.getJavaField()));
		}
		return attributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.jpa.TMJpaEntity#getJpaAttributeByName(java.lang. String)
	 */
	@Override
	public JxJpaAttribute findJpaAttributeByName(String name) throws JxElementNotFoundException {
		return new JxJpaAttributeImpl(this.findAttributeByName(name).getJavaField());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJpaEntity#findPersitenceController()
	 */
	@Override
	public JxDemoisellePersistenceController findPersitenceController() throws JxElementNotFoundException {
		final JxJpaEntity jpaEntity = this;
		JxDemoiselleProject demoiselleProject = new JxDemoiselleProjectImpl(mavenProject);
		return demoiselleProject.findAllPersistenceControllers().find(new Predicate<JxDemoisellePersistenceController>() {
			@Override
			public boolean apply(JxDemoisellePersistenceController arg0) {
				if (arg0.getSuperClassGenericTypeArgument(0) != null) {
					return arg0.getSuperClassGenericTypeArgument(0).getFullyQualifiedName().equals(jpaEntity.getFullyQualifiedName());
				}
				return false;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJpaEntity#findBusinessController()
	 */
	@Override
	public JxDemoiselleBusinessController findBusinessController() throws JxElementNotFoundException {
		final JxJpaEntity jpaEntity = this;
		JxDemoiselleProject demoiselleProject = new JxDemoiselleProjectImpl(mavenProject);
		return demoiselleProject.findAllBusinessControllers().find(new Predicate<JxDemoiselleBusinessController>() {
			@Override
			public boolean apply(JxDemoiselleBusinessController arg0) {
				if (arg0.getSuperClassGenericTypeArgument(0) != null) {
					return arg0.getSuperClassGenericTypeArgument(0).getFullyQualifiedName().equals(jpaEntity.getFullyQualifiedName());
				}
				return false;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJpaEntity#getMavenProject()
	 */
	@Override
	public JxMavenProject getMavenProject() {
		return getMavenProject();
	}

}
