package jtools.commons.model.demoiselle;

import jtools.commons.model.MMavenProject;
import jtools.commons.model.jpa.MJpaEntity;
import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo maven demoiselle.
 * 
 * @author jcruz
 *
 */
public interface MDemoiselleProject extends MMavenProject {

	/**
	 * 
	 * Retorna todas as entidades JPA do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<MJpaEntity> getAllJpaEntities();

	/**
	 * 
	 * Retorna todos os Persistence Controllers (DAOs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<MPersistenceController> getAllPersistenceControllers();

	/**
	 * 
	 * Retorna todos os Business Controllers (BCs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<MBusinessController> getAllBusinessControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Edição do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<MEditViewController> getAllEditViewControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Listagem do projeto demoiselle.
	 * 
	 * @return
	 */
	public TCollection<MListViewController> getAllListViewControllers();
}
