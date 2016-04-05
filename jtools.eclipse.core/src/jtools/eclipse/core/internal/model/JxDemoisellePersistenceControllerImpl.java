package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJpaEntity;

/**
 * @author jcruz
 *
 */
public class JxDemoisellePersistenceControllerImpl extends JxBeanImpl implements JxDemoisellePersistenceController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private JxDemoiselleProject demoiselleProject;

	/**
	 * 
	 * @param demoiselleProject
	 * @param javaClass
	 */
	public JxDemoisellePersistenceControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoisellePersistenceController#getDemoiselleProject()
	 */
	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoisellePersistenceController#findBusinessController()
	 */
	@Override
	public JxDemoiselleBusinessController findBusinessController() throws JxElementNotFoundException {
		final JxDemoisellePersistenceController persistenceController = this;
		return demoiselleProject.findAllBusinessControllers().find(new Predicate<JxDemoiselleBusinessController>() {
			@Override
			public boolean apply(JxDemoiselleBusinessController arg0) {
				if (arg0.getSuperClassGenericTypeArgument(2) != null) {
					return arg0.getSuperClassGenericTypeArgument(2).getFullyQualifiedName()
							.equals(persistenceController.getFullyQualifiedName());
				}
				return false;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoisellePersistenceController#findJpaEntity()
	 */
	@Override
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException {
		final JxDemoisellePersistenceController persistenceController = this;
		return demoiselleProject.findAllJpaEntities().find(new Predicate<JxJpaEntity>() {
			@Override
			public boolean apply(JxJpaEntity arg0) {
				return arg0.getFullyQualifiedName()
						.equals(persistenceController.getSuperClassGenericTypeArgument(0).getFullyQualifiedName());
			}
		});
	}

}
