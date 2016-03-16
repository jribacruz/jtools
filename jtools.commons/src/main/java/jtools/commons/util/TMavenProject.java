package jtools.commons.util;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import jtools.commons.exception.InvalidProjectTypeException;
import jtools.commons.model.TMMavenProject;

/**
 * 
 * @author jcruz
 *
 */
public class TMavenProject {

	public static final String POM_NAME = "pom.xml";

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isMavenProject(String path) {
		return new File(String.format("%s/%s", FilenameUtils.normalizeNoEndSeparator(path), POM_NAME)).exists();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static TMMavenProject create(String path) throws InvalidProjectTypeException {
		if (isMavenProject(path)) {

		}
		throw new InvalidProjectTypeException("O projeto não é Maven.");
	}

}
