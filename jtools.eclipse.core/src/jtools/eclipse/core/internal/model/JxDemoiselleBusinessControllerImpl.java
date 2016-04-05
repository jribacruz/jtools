package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJpaEntity;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleBusinessControllerImpl extends JxBeanImpl implements JxDemoiselleBusinessController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JxDemoiselleProject demoiselleProject;

	public JxDemoiselleBusinessControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleBusinessController#getDemoiselleProject()
	 */
	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleBusinessController#findJpaEntity()
	 */
	@Override
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException {
		final JxDemoiselleBusinessController businessController = this;
		return demoiselleProject.findAllJpaEntities().find(new Predicate<JxJpaEntity>() {
			@Override
			public boolean apply(JxJpaEntity arg0) {
				return arg0.getFullyQualifiedName().equals(businessController.getSuperClassGenericTypeArgumentByIndex(0).getFullyQualifiedName());
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleBusinessController#findPersistenceController()
	 */
	@Override
	public JxDemoisellePersistenceController findPersistenceController() throws JxElementNotFoundException {
		final JxDemoiselleBusinessController businessController = this;
		return demoiselleProject.findAllPersistenceControllers().find(new Predicate<JxDemoisellePersistenceController>() {
			@Override
			public boolean apply(JxDemoisellePersistenceController arg0) {
				return arg0.getFullyQualifiedName().equals(businessController.getSuperClassGenericTypeArgumentByIndex(2).getFullyQualifiedName());
			}
		});
	}

}
