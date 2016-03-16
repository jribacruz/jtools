package jtools.commons.model;

import java.util.Collection;

/**
 * Classe que representa um bean CDI.
 * 
 * @author jcruz
 *
 */
public interface TMBean extends TMClass {

	/**
	 * 
	 * @return
	 */
	public Collection<TMBean> getFieldInjections();

	/**
	 * 
	 * @param tmClass
	 */
	public void hasFieldInjection(TMClass tmClass);
}
