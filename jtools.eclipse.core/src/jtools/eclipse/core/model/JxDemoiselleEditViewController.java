package jtools.eclipse.core.model;

import jtools.eclipse.core.exception.JxElementNotFoundException;

/**
 * 
 * @author jcruz
 *
 */
public interface JxDemoiselleEditViewController extends JxBean {
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
	public JxJpaEntity findJpaEntity() throws JxElementNotFoundException;
}
