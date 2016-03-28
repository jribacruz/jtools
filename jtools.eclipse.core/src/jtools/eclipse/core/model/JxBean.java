package jtools.eclipse.core.model;

import jtools.eclipse.core.util.JxCollection;


/**
 * Classe que representa um bean CDI.
 * 
 * @author jcruz
 *
 */
public interface JxBean extends JxJavaClass {

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJavaClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
