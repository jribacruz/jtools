package jtools.commons.model;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import jtools.commons.internal.model.TMDirImpl;

@RunWith(JUnit4.class)
public class TMDirTestCase {

	@Test
	public void getFilesTest() {
		TMDir dir = new TMDirImpl(new File("src/test/java"));
		System.out.println(dir.getFiles());
	}
	
	@Test
	public void getChildDirsTest() {
		TMDir dir = new TMDirImpl(new File("src/test/java"));
		System.out.println(dir.getChildDirs());
	}
	
	@Test
	public void getParentTest() {
		TMDir dir = new TMDirImpl(new File("src/test/java/jtools/commons"));
		System.out.println(dir.getParent());
	}
}
