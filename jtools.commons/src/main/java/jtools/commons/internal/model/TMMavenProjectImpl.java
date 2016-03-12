package jtools.commons.internal.model;

import jtools.commons.model.TMJava;
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
	public TMPersistence gePersistence() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaMainClasses()
	 */
	@Override
	public TCollection<TMJava> getSrcJavaMainClasses() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMMavenProject#getSrcJavaTestClasses()
	 */
	@Override
	public TCollection<TMJava> getSrcJavaTestClasses() {
		return null;
	}

}
