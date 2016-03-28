package jtools.eclipse.core.internal.model.demoiselle;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.internal.function.FunctionJxClassToJxBusinessController;
import jtools.eclipse.core.internal.function.FunctionJxClassToJxEditViewController;
import jtools.eclipse.core.internal.function.FunctionJxClassToJxJpaEntity;
import jtools.eclipse.core.internal.function.FunctionJxClassToJxListViewController;
import jtools.eclipse.core.internal.function.FunctionJxClassToJxPersistenceController;
import jtools.eclipse.core.internal.model.JxMavenProjectImpl;
import jtools.eclipse.core.internal.predicate.PredicateIsJxBusinessController;
import jtools.eclipse.core.internal.predicate.PredicateIsJxEditViewController;
import jtools.eclipse.core.internal.predicate.PredicateIsJxJpaEntity;
import jtools.eclipse.core.internal.predicate.PredicateIsJxListViewController;
import jtools.eclipse.core.internal.predicate.PredicateIsJxPersistenceController;
import jtools.eclipse.core.model.demoiselle.JxBusinessController;
import jtools.eclipse.core.model.demoiselle.JxDemoiselleProject;
import jtools.eclipse.core.model.demoiselle.JxEditViewController;
import jtools.eclipse.core.model.demoiselle.JxListViewController;
import jtools.eclipse.core.model.demoiselle.JxPersistenceController;
import jtools.eclipse.core.model.jpa.JxJpaEntity;

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
