package jtools.eclipse.core.model;

import jtools.eclipse.core.XCollection;


/**
 * Classe que representa um bean CDI.
 * 
 * @author jcruz
 *
 */
public interface JxBean extends JxClass {

	/**
	 * 
	 * @return
	 */
	public XCollection<JxClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
