package jtools.commons.model;

import java.util.Collection;

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
	public Collection<MClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
