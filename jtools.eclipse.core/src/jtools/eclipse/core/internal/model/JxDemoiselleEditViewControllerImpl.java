package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.model.JxDemoiselleEditViewController;
import jtools.eclipse.core.model.JxDemoiselleProject;

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

	private JxDemoiselleProject demoiselleProject;

	public JxDemoiselleEditViewControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

}
