package jtools.commons.model;

import java.io.Serializable;

public interface TMMavenProject extends Serializable {

	/**
	 * 
	 * @return
	 */
	public TMPom getPom();

	/**
	 * 
	 * @return
	 */
	public TMPrettyConfig gePrettyConfig();

	/**
	 * 
	 * @return
	 */
	public TMPersistence gePersistence();

}
