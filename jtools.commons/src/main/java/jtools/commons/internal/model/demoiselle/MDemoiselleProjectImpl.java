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
import jtools.commons.model.demoiselle.XBusinessController;
import jtools.commons.model.demoiselle.XDemoiselleProject;
import jtools.commons.model.demoiselle.XEditViewController;
import jtools.commons.model.demoiselle.XListViewController;
import jtools.commons.model.demoiselle.XPersistenceController;
import jtools.commons.model.jpa.XJpaEntity;
import jtools.commons.types.XCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MDemoiselleProjectImpl extends MMavenProjectImpl implements XDemoiselleProject {

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
	public XCollection<XJpaEntity> getAllJpaEntities() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMJpaEntity(), new FunctionMClassToMJpaEntity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public XCollection<XPersistenceController> getAllPersistenceControllers() {
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
	public XCollection<XBusinessController> getAllBusinessControllers() {
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
	public XCollection<XEditViewController> getAllEditViewControllers() {
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
	public XCollection<XListViewController> getAllListViewControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsMListViewController(), new FunctionMClassToMListViewController());
	}

}
