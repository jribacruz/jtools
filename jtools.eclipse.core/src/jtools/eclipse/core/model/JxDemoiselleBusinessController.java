package jtools.eclipse.core.model;

/**
 * 
 * @author jcruz
 *
 */
public interface JxDemoiselleBusinessController extends JxBean {

	/**
	 * 
	 * Retorna o Persistence Controller referenciado pelo BusinessController
	 * 
	 * @return
	 */
	public JxDemoisellePersistenceController getPersistenceController();

	/**
	 * 
	 * Retorna a entidade do Business Controller
	 * 
	 * @return
	 */
	public JxJpaEntity getJpaEntity();

}
