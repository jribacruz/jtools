package jtools.eclipse.core.internal.model;

import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleBusinessController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleEditViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxJpaEntity;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleListViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoisellePersistenceController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleBusinessController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleEditViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxJpaEntity;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleListViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxDemoiselleEditViewController;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.util.JxCollection;

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
	public JxCollection<JxJpaEntity> getAllJpaEntities() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxJpaEntity(), new FunctionJxClassToJxJpaEntity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#
	 * getAllPersistenceControllers()
	 */
	@Override
	public JxCollection<JxDemoisellePersistenceController> getAllPersistenceControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoisellePersistenceController(),
				new FunctionJxClassToJxDemoisellePersistenceController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllBusinessControllers
	 * ()
	 */
	@Override
	public JxCollection<JxDemoiselleBusinessController> getAllBusinessControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleBusinessController(), new FunctionJxClassToJxDemoiselleBusinessController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEditViewControllers
	 * ()
	 */
	@Override
	public JxCollection<JxDemoiselleEditViewController> getAllEditViewControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleEditViewController(), new FunctionJxClassToJxDemoiselleEditViewController());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.demoiselle.TMDemoiselleProject#getAllListViewControllers
	 * ()
	 */
	@Override
	public JxCollection<JxDemoiselleListViewController> getAllListViewControllers() {
		return getSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleListViewController(), new FunctionJxClassToJxDemoiselleListViewController());
	}

}
