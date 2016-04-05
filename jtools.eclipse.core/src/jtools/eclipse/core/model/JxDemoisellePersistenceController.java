package jtools.eclipse.core.model;

import jtools.eclipse.core.exception.JxElementNotFoundException;

/**
 * 
 * @author jcruz
 *
 */
public interface JxDemoisellePersistenceController extends JxBean {
	/**
	 * 
	 * @return
	 */
	public JxDemoiselleProject getDemoiselleProject();

	/**
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxDemoiselleBusinessController findBusinessController() throws JxElementNotFoundException;

	/**
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException;

}
