package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * Classe que representa um arquivo pom.xml
 * 
 * @author jcruz
 *
 */
public interface MPom {
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
	public TCollection<MPomDependency> getDependencies();

	/**
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 * @return
	 */
	public boolean hasDependency(String groupId, String artifactId, String version);

	/**
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 */
	public void addDependency(String groupId, String artifactId, String version);

	/**
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 */
	public void removeDependency(String groupId, String artifactId, String version);

}
