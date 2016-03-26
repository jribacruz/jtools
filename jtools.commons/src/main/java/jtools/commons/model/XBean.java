package jtools.commons.model;

import jtools.commons.types.XCollection;

/**
 * Classe que representa um bean CDI.
 * 
 * @author jcruz
 *
 */
public interface XBean extends XClass {

	/**
	 * 
	 * @return
	 */
	public XCollection<XClassAttribute> getInjectedAttributes();

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean isInjectedAttribute(String attributeName);

}
