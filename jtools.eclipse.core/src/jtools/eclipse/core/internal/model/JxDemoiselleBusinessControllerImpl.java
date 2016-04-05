package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

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
	 * @see jtools.eclipse.core.model.JxDemoiselleBusinessController# getPersistenceController()
	 */
	@Override
	public JxDemoisellePersistenceController getPersistenceController() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxDemoiselleBusinessController#getJpaEntity()
	 */
	@Override
	public JxJpaEntity getJpaEntity() {
		return null;
	}

	@Override
	public JxDemoiselleProject getDemoiselleProject() {
		return this.demoiselleProject;
	}

}
