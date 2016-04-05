package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;

/**
 * @author jcruz
 *
 */
public class JxDemoisellePersistenceControllerImpl extends JxBeanImpl implements JxDemoisellePersistenceController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JxDemoiselleProject demoiselleProject;

	public JxDemoisellePersistenceControllerImpl(JxDemoiselleProject demoiselleProject, JavaClass javaClass) {
		super(javaClass);
		this.demoiselleProject = demoiselleProject;
	}

	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

}
