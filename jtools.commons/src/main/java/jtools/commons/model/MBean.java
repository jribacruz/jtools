package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * Classe que representa um bean CDI.
 * 
 * @author jcruz
 *
 */
public interface MBean extends MClass {

	/**
	 * 
	 * @return
	 */
	public TCollection<MClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
