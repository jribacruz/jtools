package jtools.commons.model.demoiselle;

import jtools.commons.model.TMJpaEntity;
import jtools.commons.model.TMMavenProject;
import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo maven demoiselle.
 * 
 * @author jcruz
 *
 */
public interface TMDemoiselleProject extends TMMavenProject {

	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaEntity> getAllJpaEntities();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPersistenceController> getAllPersistenceControllers();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMBusinessController> getAllBusinessControllers();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMEditViewController> getAllEditViewControllers();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMListViewController> getAllListViewControllers();
}
