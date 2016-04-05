package jtools.eclipse.core.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.test.fixture.DemoiselleProject;

@RunWith(JUnit4.class)
public class JxJavaClassTest {

	@Test
	public void getBCGenericTypeArgument_Test() throws FileNotFoundException, IOException {
		JxDemoiselleProject demoiselleProject = DemoiselleProject.create();
		JxJavaClass javaClass = demoiselleProject.findSrcMainJavaClassByFullyQualifiedName("jtools.eclipse.demoiselle.test.business.FooBC");
		System.out.println(javaClass.getSuperClassGenericTypeArgument(0));
		System.out.println(javaClass.getSuperClassGenericTypeArgument(1));
	}

	@Test
	public void getBCSuperClass_Test() throws FileNotFoundException, IOException {
		JxDemoiselleProject demoiselleProject = DemoiselleProject.create();
		JxJavaClass javaClass = demoiselleProject.findSrcMainJavaClassByFullyQualifiedName("jtools.eclipse.demoiselle.test.business.FooBC");
		System.out.println(javaClass.getSuperClass());
	}

}
