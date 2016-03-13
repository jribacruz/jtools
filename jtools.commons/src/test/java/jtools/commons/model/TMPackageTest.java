package jtools.commons.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.commons.internal.model.TMPackageImpl;

@RunWith(JUnit4.class)
public class TMPackageTest {

	@Test
	public void getClassesTest() throws FileNotFoundException, IOException {
		TMPackage package1 = new TMPackageImpl(new File("src/test/java/jtools/commons/model"));
		System.out.println(package1.getClasses());
	}
}
