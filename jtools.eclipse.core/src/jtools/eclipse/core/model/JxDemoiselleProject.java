package jtools.eclipse.core.model;

import jtools.eclipse.core.JxCollection;

/**
 * Classe que representa um arquivo maven demoiselle.
 * 
 * @author jcruz
 *
 */
public interface JxDemoiselleProject extends JxMavenProject {

	/**
	 * 
	 * Retorna todas as entidades JPA do projeto demoiselle.
	 * 
	 * @return
	 */
	public JxCollection<JxJpaEntity> getAllJpaEntities();

	/**
	 * 
	 * Retorna todos os Persistence Controllers (DAOs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public JxCollection<JxPersistenceController> getAllPersistenceControllers();

	/**
	 * 
	 * Retorna todos os Business Controllers (BCs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public JxCollection<JxBusinessController> getAllBusinessControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Edição do projeto demoiselle.
	 * 
	 * @return
	 */
	public JxCollection<JxEditViewController> getAllEditViewControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Listagem do projeto demoiselle.
	 * 
	 * @return
	 */
	public JxCollection<JxListViewController> getAllListViewControllers();
}
