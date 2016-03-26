package jtools.commons.model;

import jtools.commons.types.XCollection;

/**
 * Classe que reprensenta um arquivo pretty-config.xml
 * 
 * @author jcruz
 *
 */
public interface XPrettyConfig {

	/**
	 * 
	 * Lista com os mapeamentos do arquivo pretty-config.xml
	 * 
	 * @return
	 */
	public XCollection<XPrettyConfigMapping> geMappings();
}
