package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface TMPom {
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
	public TCollection<TMPomDependency> getDependencies();

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
