package jtools.eclipse.core.service;

import java.io.File;

import jtools.eclipse.core.internal.model.JxDemoiselleProjectImpl;
import jtools.eclipse.core.model.JxDemoiselleProject;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IProject;

/**
 * 
 * @author jcruz
 *
 */
public class MavenProjectService {

	public static final String POM_NAME = "pom.xml";

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isMavenProject(String path) {
		return new File(String.format("%s/%s", FilenameUtils.normalizeNoEndSeparator(path), POM_NAME)).exists();
	}

	public static JxDemoiselleProject getSelectedDemoiselleProject() {
		IProject project = SelectionService.getProjectFromSelection();
		if (project != null) {
			return new JxDemoiselleProjectImpl(project.getFullPath().toString());
		}
		return null;
	}

}
