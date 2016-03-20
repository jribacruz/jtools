package jtools.commons.model;

/**
 * 
 * Classe que representa uma entrada de mapeamento no arquivo pretty-config.xml
 * 
 * @author jcruz
 *
 */
public interface MPrettyConfigMapping {
	/**
	 * 
	 * @return
	 */
	public String getId();

	/**
	 * 
	 * @return
	 */
	public String getPattern();

	/**
	 * 
	 * @return
	 */
	public String getViewId();

	/**
	 * 
	 * @return
	 */
	public String getAction();
}
