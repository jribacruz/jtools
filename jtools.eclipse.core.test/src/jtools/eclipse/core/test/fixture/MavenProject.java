package jtools.eclipse.core.test.fixture;

import java.io.File;

import jtools.eclipse.core.internal.model.JxMavenProjectImpl;
import jtools.eclipse.core.model.JxMavenProject;

public class MavenProject {

	public static JxMavenProject create() {
		File file = new File("./../jtools.eclipse.demoiselle.test");
		JxMavenProject mavenProject = new JxMavenProjectImpl(file.getAbsolutePath());
		return mavenProject;
	}
	
}
