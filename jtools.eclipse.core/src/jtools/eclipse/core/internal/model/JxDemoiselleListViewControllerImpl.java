package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJpaEntity;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleListViewControllerImpl extends JxBeanImpl implements JxDemoiselleListViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JxDemoiselleProject demoiselleProject;

	public JxDemoiselleListViewControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleListViewController#getDemoiselleProject()
	 */
	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleListViewController#findJpaEntity()
	 */
	@Override
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException {
		final JxDemoiselleListViewController listViewController = this;
		return demoiselleProject.findAllJpaEntities().find(new Predicate<JxJpaEntity>() {
			@Override
			public boolean apply(JxJpaEntity arg0) {
				return arg0.getFullyQualifiedName().equals(listViewController.getSuperClassGenericTypeArgumentByIndex(0).getFullyQualifiedName());
			}
		});
	}

}
