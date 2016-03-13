package jtools.commons.model;

import java.io.Serializable;

import jtools.commons.types.TCollection;

/**
 * Modelo do projeto Maven.
 * 
 * @author jcruz
 *
 */
public interface TMMavenProject extends Serializable {

	/**
	 * Modelo do pom.xml
	 * 
	 * @return
	 */
	public TMPom getPom();

	/**
	 * 
	 * Modelo do pretty-config.xml
	 * 
	 * @return
	 */
	public TMPrettyConfig gePrettyConfig();

	/**
	 * Modelo do persistence.xml de src/main/resources
	 * 
	 * @return
	 */
	public TMPersistence geSrcMainResourcesPersistence();

	/**
	 * Modelo do persistence.xml de src/test/resources
	 * 
	 * @return
	 */
	public TMPersistence getSrcTestResourcesPersistence();

	/**
	 * 
	 * Coleção com todos os modelos das classes de src/main/java
	 * 
	 * @return
	 */
	public TCollection<TMClass> getSrcMainJavaClasses();

	/**
	 * Colação com todos os modelos das classes de src/test/java
	 * 
	 * @return
	 */
	public TCollection<TMClass> getSrcTestJavaClasses();
	
	/**
	 * 
	 * @return
	 */
	public TCollection<TMDir> getSrcMainWebappDirs();

}
