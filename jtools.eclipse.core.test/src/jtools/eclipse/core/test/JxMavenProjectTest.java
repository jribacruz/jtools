package jtools.eclipse.core.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.eclipse.core.model.JxMavenProject;
import jtools.eclipse.core.test.fixture.MavenProject;

@RunWith(JUnit4.class)
public class JxMavenProjectTest {

	@Test
	public void findAllSrcMainJavaClasses_test() {
		JxMavenProject mavenProject = MavenProject.create();
		System.out.println(mavenProject.findAllSrcMainJavaClasses());
	}

}
