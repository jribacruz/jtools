package jtools.eclipse.core.model;

import jtools.eclipse.core.util.JxCollection;


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
	public JxCollection<JxClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
