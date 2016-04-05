package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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

	public JxDemoiselleBusinessControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

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
