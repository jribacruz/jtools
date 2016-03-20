package jtools.commons.util;

import java.io.File;

import jtools.commons.model.MMavenProject;

import org.apache.commons.io.FilenameUtils;

/**
 * 
 * @author jcruz
 *
 */
public class MavenProject {

	public static final String POM_NAME = "pom.xml";

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isMavenProject(String path) {
		return new File(String.format("%s/%s", FilenameUtils.normalizeNoEndSeparator(path), POM_NAME)).exists();
	}

}
