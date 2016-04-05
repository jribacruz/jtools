package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
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

	public JxDemoiselleBusinessControllerImpl(JavaClass javaClass) {
		super(javaClass);
		// TODO Auto-generated constructor stub
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

}
