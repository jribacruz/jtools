package jtools.commons.internal.model.demoiselle;

import jtools.commons.internal.model.MMavenProjectImpl;
import jtools.commons.internal.model.demoiselle.function.FunctionMBusinessController;
import jtools.commons.internal.model.demoiselle.function.FunctionMJpaEntity;
import jtools.commons.internal.model.demoiselle.function.FunctionMPersistenceController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateMBusinessController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateMJpaEntity;
import jtools.commons.internal.model.demoiselle.predicate.PredicateMPersistenceController;
import jtools.commons.model.demoiselle.MBusinessController;
import jtools.commons.model.demoiselle.MDemoiselleProject;
import jtools.commons.model.demoiselle.MEditViewController;
import jtools.commons.model.demoiselle.MListViewController;
import jtools.commons.model.demoiselle.MPersistenceController;
import jtools.commons.model.jpa.MJpaEntity;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MDemoiselleProjectImpl extends MMavenProjectImpl implements MDemoiselleProject {

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
	public TCollection<MJpaEntity> getAllJpaEntities() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateMJpaEntity(), new FunctionMJpaEntity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public TCollection<MPersistenceController> getAllPersistenceControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateMPersistenceController(),
				new FunctionMPersistenceController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllBusinessControllers
	 * ()
	 */
	@Override
	public TCollection<MBusinessController> getAllBusinessControllers() {
		return getSrcMainJavaClasses()
				.filterAndTransform(new PredicateMBusinessController(), new FunctionMBusinessController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEditViewControllers
	 * ()
	 */
	@Override
	public TCollection<MEditViewController> getAllEditViewControllers() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllListViewControllers
	 * ()
	 */
	@Override
	public TCollection<MListViewController> getAllListViewControllers() {
		return null;
	}

}
