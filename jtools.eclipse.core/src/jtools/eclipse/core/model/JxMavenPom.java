package jtools.eclipse.core.model;

import jtools.eclipse.core.util.JxCollection;

/**
 * Classe que representa um arquivo pom.xml
 * 
 * @author jcruz
 *
 */
public interface JxMavenPom extends JxXml {
	/**
	 * 
	 * GroupId do pom.xml
	 * 
	 * @return
	 */
	public String getGroupId();

	/**
	 * 
	 * ArtifactId do pom.xml
	 * 
	 * @return
	 */
	public String getArtifactId();

	/**
	 * 
	 * Version do pom.xml
	 * 
	 * @return
	 */
	public String getVersion();

	/**
	 * 
	 * Retorna a lista de dependencias do pom.xml
	 * 
	 * @return
	 */
	public JxCollection<JxMavenPomDependency> findAllDependencies();

	/**
	 * 
	 * Verifica se o pom.xml possui a dependencia especificada.
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 * @return
	 */
	public boolean hasDependency(String groupId, String artifactId, String version);

	/**
	 * 
	 * Adiciona uma dependencia ao pom.xml
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 */
	public void addDependency(String groupId, String artifactId, String version);

	/**
	 * 
	 * Remove a dependencia do pom.xml
	 * 
	 * @param groupId
	 * @param artifactId
	 * @param version
	 */
	public void removeDependency(String groupId, String artifactId, String version);

}