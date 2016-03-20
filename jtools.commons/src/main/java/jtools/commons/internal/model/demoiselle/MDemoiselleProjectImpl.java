package jtools.commons.internal.model.demoiselle;

import jtools.commons.exception.InvalidProjectTypeException;
import jtools.commons.internal.model.MMavenProjectImpl;
import jtools.commons.internal.model.demoiselle.function.FunctionMClassToMBusinessController;
import jtools.commons.internal.model.demoiselle.function.FunctionMClassToMEditViewController;
import jtools.commons.internal.model.demoiselle.function.FunctionMClassToMJpaEntity;
import jtools.commons.internal.model.demoiselle.function.FunctionMClassToMListViewController;
import jtools.commons.internal.model.demoiselle.function.FunctionMClassToMPersistenceController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateIsMBusinessController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateIsMEditViewController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateIsMJpaEntity;
import jtools.commons.internal.model.demoiselle.predicate.PredicateIsMListViewController;
import jtools.commons.internal.model.demoiselle.predicate.PredicateIsMPersistenceController;
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

	public MDemoiselleProjectImpl(String mavenProjectPath) throws InvalidProjectTypeException {
		super(mavenProjectPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEntities()
	 */
	@Override
	public TCollection<MJpaEntity> getAllJpaEntities() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMJpaEntity(), new FunctionMClassToMJpaEntity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public TCollection<MPersistenceController> getAllPersistenceControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMPersistenceController(),
				new FunctionMClassToMPersistenceController());
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
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMBusinessController(), new FunctionMClassToMBusinessController());
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
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMEditViewController(), new FunctionMClassToMEditViewController());
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
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMListViewController(), new FunctionMClassToMListViewController());
	}

}
