package jtools.eclipse.core.test.fixture;

import java.io.File;

import jtools.eclipse.core.internal.model.JxDemoiselleProjectImpl;
import jtools.eclipse.core.model.JxDemoiselleProject;

public class DemoiselleProject {

	public static JxDemoiselleProject create() {
		File file = new File("./../jtools.eclipse.demoiselle.test");
		JxDemoiselleProject demoiselleProject = new JxDemoiselleProjectImpl(file.getAbsolutePath());
		return demoiselleProject;
	}
	
}
