package jtools.eclipse.core.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.internal.model.JxJpaEntityImpl;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.test.fixture.DemoiselleProject;

@RunWith(JUnit4.class)
public class JxJpaEntityTest {

	@Test
	public void getPersistenceControllerFromEntity_Test() throws FileNotFoundException, IOException, JxElementNotFoundException {
		JxDemoiselleProject demoiselleProject = DemoiselleProject.create();
		JxJavaClass javaClass = demoiselleProject.findSrcMainJavaClassByFullyQualifiedName("jtools.eclipse.demoiselle.test.domain.Foo");
		JxJpaEntity jpaEntity = new JxJpaEntityImpl(demoiselleProject, javaClass.getJavaClass());
		System.out.println(jpaEntity.findPersitenceController());
	}

	@Test
	public void getBusinessControllerFromEntity_Test() throws FileNotFoundException, IOException, JxElementNotFoundException {
		JxDemoiselleProject demoiselleProject = DemoiselleProject.create();
		JxJavaClass javaClass = demoiselleProject.findSrcMainJavaClassByFullyQualifiedName("jtools.eclipse.demoiselle.test.domain.Foo");
		JxJpaEntity jpaEntity = new JxJpaEntityImpl(demoiselleProject, javaClass.getJavaClass());
		System.out.println(jpaEntity.findBusinessController());
	}

}
