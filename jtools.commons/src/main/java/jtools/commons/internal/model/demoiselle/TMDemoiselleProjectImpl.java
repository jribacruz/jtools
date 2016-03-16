package jtools.commons.internal.model.demoiselle;

import jtools.commons.internal.model.TMMavenProjectImpl;
import jtools.commons.model.TMJpaEntity;
import jtools.commons.model.demoiselle.TMBusinessController;
import jtools.commons.model.demoiselle.TMDemoiselleProject;
import jtools.commons.model.demoiselle.TMEditViewController;
import jtools.commons.model.demoiselle.TMListViewController;
import jtools.commons.model.demoiselle.TMPersistenceController;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMDemoiselleProjectImpl extends TMMavenProjectImpl implements TMDemoiselleProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEntities()
	 */
	@Override
	public TCollection<TMJpaEntity> getAllJpaEntities() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public TCollection<TMPersistenceController> getAllPersistenceControllers() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllBusinessControllers
	 * ()
	 */
	@Override
	public TCollection<TMBusinessController> getAllBusinessControllers() {
		return null;
	}

	@Override
	public TCollection<TMEditViewController> getAllEditViewControllers() {
		return null;
	}

	@Override
	public TCollection<TMListViewController> getAllListViewControllers() {
		return null;
	}

}
