package jtools.eclipse.core.internal.model;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxBusinessController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxEditViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxJpaEntity;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxListViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxPersistenceController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxBusinessController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxEditViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxJpaEntity;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxListViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxPersistenceController;
import jtools.eclipse.core.model.JxBusinessController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxEditViewController;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.model.JxListViewController;
import jtools.eclipse.core.model.JxPersistenceController;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleProjectImpl extends JxMavenProjectImpl implements JxDemoiselleProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxDemoiselleProjectImpl(String mavenProjectPath){
		super(mavenProjectPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEntities()
	 */
	@Override
	public XCollection<JxJpaEntity> getAllJpaEntities() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxJpaEntity(), new FunctionJxClassToJxJpaEntity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public XCollection<JxPersistenceController> getAllPersistenceControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxPersistenceController(),
				new FunctionJxClassToJxPersistenceController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllBusinessControllers
	 * ()
	 */
	@Override
	public XCollection<JxBusinessController> getAllBusinessControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxBusinessController(), new FunctionJxClassToJxBusinessController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEditViewControllers
	 * ()
	 */
	@Override
	public XCollection<JxEditViewController> getAllEditViewControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxEditViewController(), new FunctionJxClassToJxEditViewController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllListViewControllers
	 * ()
	 */
	@Override
	public XCollection<JxListViewController> getAllListViewControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxListViewController(), new FunctionJxClassToJxListViewController());
	}

}
