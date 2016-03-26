package jtools.commons.model.demoiselle;

import jtools.commons.model.XMavenProject;
import jtools.commons.model.jpa.XJpaEntity;
import jtools.commons.types.XCollection;

/**
 * Classe que representa um arquivo maven demoiselle.
 * 
 * @author jcruz
 *
 */
public interface XDemoiselleProject extends XMavenProject {

	/**
	 * 
	 * Retorna todas as entidades JPA do projeto demoiselle.
	 * 
	 * @return
	 */
	public XCollection<XJpaEntity> getAllJpaEntities();

	/**
	 * 
	 * Retorna todos os Persistence Controllers (DAOs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public XCollection<XPersistenceController> getAllPersistenceControllers();

	/**
	 * 
	 * Retorna todos os Business Controllers (BCs) do projeto demoiselle.
	 * 
	 * @return
	 */
	public XCollection<XBusinessController> getAllBusinessControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Edição do projeto demoiselle.
	 * 
	 * @return
	 */
	public XCollection<XEditViewController> getAllEditViewControllers();

	/**
	 * 
	 * Retorna todos os Managed Beans de Listagem do projeto demoiselle.
	 * 
	 * @return
	 */
	public XCollection<XListViewController> getAllListViewControllers();
}
