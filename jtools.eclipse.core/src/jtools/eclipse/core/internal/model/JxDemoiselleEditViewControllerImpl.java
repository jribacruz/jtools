package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxDemoiselleEditViewController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJpaEntity;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleEditViewControllerImpl extends JxBeanImpl implements JxDemoiselleEditViewController {

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
	public JxDemoiselleEditViewControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleEditViewController#getDemoiselleProject()
	 */
	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleEditViewController#findJpaEntity()
	 */
	@Override
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException {
		final JxDemoiselleEditViewController editViewController = this;
		return demoiselleProject.findAllJpaEntities().find(new Predicate<JxJpaEntity>() {
			@Override
			public boolean apply(JxJpaEntity arg0) {
				return arg0.getFullyQualifiedName().equals(editViewController.getSuperClassGenericTypeArgument(0).getFullyQualifiedName());
			}
		});
	}

}
