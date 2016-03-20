package jtools.commons.model;

import java.io.Serializable;

/**
 * 
 * Classe que representa uma dependencia no arquivo pom.xml
 * 
 * @author jcruz
 *
 */
public interface MPomDependency extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getGroupId();

	/**
	 * 
	 * @return
	 */
	public String getArtifactId();

	/**
	 * 
	 * @return
	 */
	public String getVersion();

	/**
	 * 
	 * @return
	 */
	public String getScope();
}
