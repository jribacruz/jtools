package jtools.commons.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

/**
 * 
 * @author jcruz
 *
 */
public interface TGeneratorJavaUpdater {

	/**
	 * 
	 */
	public void update();

	public JavaClassSource inClass();
}