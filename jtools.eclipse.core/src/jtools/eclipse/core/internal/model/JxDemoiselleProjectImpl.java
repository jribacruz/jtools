package jtools.eclipse.core.internal.model;

import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleBusinessController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleEditViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoiselleListViewController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxDemoisellePersistenceController;
import jtools.eclipse.core.internal.model.function.FunctionJxClassToJxJpaEntity;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleBusinessController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleEditViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoiselleListViewController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxDemoisellePersistenceController;
import jtools.eclipse.core.internal.model.predicate.PredicateIsJxJpaEntity;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxDemoiselleEditViewController;
import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.model.JxMavenProject;
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

	public JxDemoiselleProjectImpl(String mavenProjectPath) {
		super(mavenProjectPath);
	}

	public JxDemoiselleProjectImpl(JxMavenProject mavenProject) {
		super(mavenProject.getMavenProjectFile().getFile().getAbsolutePath());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEntities()
	 */
	@Override
	public JxCollection<JxJpaEntity> findAllJpaEntities() {
		return findAllSrcMainJavaClasses().filterAndTransform(new PredicateIsJxJpaEntity(), new FunctionJxClassToJxJpaEntity(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject# getAllPersistenceControllers()
	 */
	@Override
	public JxCollection<JxDemoisellePersistenceController> findAllPersistenceControllers() {
		return findAllSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoisellePersistenceController(),
				new FunctionJxClassToJxDemoisellePersistenceController(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllBusinessControllers ()
	 */
	@Override
	public JxCollection<JxDemoiselleBusinessController> findAllBusinessControllers() {
		return findAllSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleBusinessController(),
				new FunctionJxClassToJxDemoiselleBusinessController(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllEditViewControllers ()
	 */
	@Override
	public JxCollection<JxDemoiselleEditViewController> findAllEditViewControllers() {
		return findAllSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleEditViewController(),
				new FunctionJxClassToJxDemoiselleEditViewController(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.demoiselle.TMDemoiselleProject#getAllListViewControllers ()
	 */
	@Override
	public JxCollection<JxDemoiselleListViewController> findAllListViewControllers() {
		return findAllSrcMainJavaClasses().filterAndTransform(new PredicateIsJxDemoiselleListViewController(),
				new FunctionJxClassToJxDemoiselleListViewController(this));
	}

}
