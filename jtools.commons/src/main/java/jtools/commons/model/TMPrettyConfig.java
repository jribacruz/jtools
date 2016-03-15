package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * Classe que reprensenta um arquivo pretty-config.xml
 * 
 * @author jcruz
 *
 */
public interface TMPrettyConfig {

	/**
	 * 
	 * @return
	 */
	public TCollection<TMPrettyConfigMapping> geMappings();
}
