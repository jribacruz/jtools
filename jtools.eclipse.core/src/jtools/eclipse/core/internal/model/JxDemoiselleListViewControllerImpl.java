package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxDemoiselleProject;

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

	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

}
