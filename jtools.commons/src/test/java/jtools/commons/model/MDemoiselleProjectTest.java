package jtools.commons.model;

import jtools.commons.exception.InvalidProjectTypeException;
import jtools.commons.internal.model.demoiselle.MDemoiselleProjectImpl;
import jtools.commons.model.demoiselle.MDemoiselleProject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MDemoiselleProjectTest {

	private MDemoiselleProject demoiselleProject;

	@Before
	public void init() throws InvalidProjectTypeException {
		this.demoiselleProject = new MDemoiselleProjectImpl("/opt/workspace-luna/aelis2016");
	}

	@Test
	public void getAllJpaEntitiesTest() {
		System.out.println(demoiselleProject.getAllJpaEntities());
	}

	@Test
	public void getAllPersistenceControllersTest() {
		System.out.println(demoiselleProject.getAllPersistenceControllers());
	}

	@Test
	public void getAllBusinessControllersTest() {
		System.out.println(demoiselleProject.getAllBusinessControllers());
	}
	
	@Test
	public void getAllEditViewControllersTest() {
		System.out.println(demoiselleProject.getAllEditViewControllers());
	}
	
	@Test
	public void getAllListViewControllersTest() {
		System.out.println(demoiselleProject.getAllListViewControllers());
	}
}
