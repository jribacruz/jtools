package jtools.eclipse.core.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.test.fixture.DemoiselleProject;

@RunWith(JUnit4.class)
public class JxDemoiselleProjectTest {

	@Test
	public void findAllPersistenceControllers_Test() throws FileNotFoundException, IOException {
		JxDemoiselleProject demoiselleProject = DemoiselleProject.create();
		System.out.println(demoiselleProject.findAllPersistenceControllers());
	}

}
