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
	 * Retorna todas as entidades JPA do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<TMJpaEntity> getAllJpaEntities();

	/**
	 * 
	 * Retorna todos os Persistence Controllers (DAOs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<TMPersistenceController> getAllPersistenceControllers();

	/**
	 * 
	 * Retorna todos os Business Controllers (BCs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<TMBusinessController> getAllBusinessControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Edição do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<TMEditViewController> getAllEditViewControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Listagem do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<TMListViewController> getAllListViewControllers();
}
