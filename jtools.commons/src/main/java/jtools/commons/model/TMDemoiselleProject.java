package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo maven demoiselle.
 * 
 * @author jcruz
 *
 */
public interface TMDemoiselleProject extends TMMavenProject {

	/**
	 * 
	 * @return
	 */
	public TCollection<TMClass> getDAOs();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMClass> getBCs();

}
