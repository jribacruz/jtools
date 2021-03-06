package jtools.commons.model;

import java.io.File;

import jtools.commons.internal.model.base.MDirImpl;
import jtools.commons.model.base.XDir;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MDirTestCase {

	@Test
	public void getFilesTest() {
		XDir dir = new MDirImpl(new File("src/test/java"));
		System.out.println(dir.getAllFiles());
	}

	@Test
	public void getChildDirsTest() {
		XDir dir = new MDirImpl(new File("src/test/java/"));
		System.out.println(dir.getChildDirs());
		Assert.assertTrue(dir.getChildDirs().size() > 0);
	}

	@Test
	@Ignore
	public void getParentTest() {
		XDir dir = new MDirImpl(new File("src/test/java/jtools/commons"));
		System.out.println(dir.getParent());
	}

	@Test
	public void getChildTest() {
		XDir dir = new MDirImpl(new File("src/test/java/jtools"));
		// System.out.println("Dir: " + dir.getChild("commons"));
		System.out.println("Commonos: " + dir.getChild("commons"));
	}
}
