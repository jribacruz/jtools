package jtools.commons.internal.model;

import jtools.commons.model.TMClass;
import jtools.commons.model.TMDir;
import jtools.commons.model.TMMavenProject;
import jtools.commons.model.TMPersistence;
import jtools.commons.model.TMPom;
import jtools.commons.model.TMPrettyConfig;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMMavenProjectImpl implements TMMavenProject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getPom()
	 */
	@Override
	public TMPom getPom() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePrettyConfig()
	 */
	@Override
	public TMPrettyConfig gePrettyConfig() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#gePersistence()
	 */
	@Override
	public TMPersistence geSrcMainResourcesPersistence() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public TCollection<TMClass> getSrcMainJavaClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public TCollection<TMClass> getSrcTestJavaClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcTestResourcesPersistence()
	 */
	@Override
	public TMPersistence getSrcTestResourcesPersistence() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcMainWebappDirs()
	 */
	@Override
	public TCollection<TMDir> getSrcMainWebappDirs() {
		return null;
	}

}
