package jtools.eclipse.core.model;

import jtools.eclipse.core.XCollection;

/**
 * Classe que reprensenta um arquivo pretty-config.xml
 * 
 * @author jcruz
 *
 */
public interface JxPrettyConfig {

	/**
	 * 
	 * Lista com os mapeamentos do arquivo pretty-config.xml
	 * 
	 * @return
	 */
	public XCollection<JxPrettyConfigMapping> geMappings();
}
