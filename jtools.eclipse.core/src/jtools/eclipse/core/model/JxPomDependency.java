package jtools.eclipse.core.model;

import java.io.Serializable;

/**
 * 
 * Classe que representa uma dependencia no arquivo pom.xml
 * 
 * @author jcruz
 *
 */
public interface JxPomDependency extends Serializable {

	/**
	 * 
	 * GroupId da dependencia.
	 * 
	 * @return
	 */
	public String getGroupId();

	/**
	 * 
	 * ArtifactId da dependencia.
	 * 
	 * @return
	 */
	public String getArtifactId();

	/**
	 * 
	 * Version da dependencia.
	 * 
	 * @return
	 */
	public String getVersion();

	/**
	 * 
	 * Scope da dependencia.
	 * 
	 * @return
	 */
	public String getScope();
}
