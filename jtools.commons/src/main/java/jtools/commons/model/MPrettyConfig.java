package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * Classe que reprensenta um arquivo pretty-config.xml
 * 
 * @author jcruz
 *
 */
public interface MPrettyConfig {

	/**
	 * 
	 * Lista com os mapeamentos do arquivo pretty-config.xml
	 * 
	 * @return
	 */
	public TCollection<MPrettyConfigMapping> geMappings();
}
