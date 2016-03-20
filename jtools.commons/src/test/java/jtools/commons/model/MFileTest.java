package jtools.commons.model;

import java.io.File;

import jtools.commons.filter.FilterCSSFile;
import jtools.commons.internal.model.base.MFileImpl;
import jtools.commons.model.base.MFile;
import jtools.commons.types.TCollection;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MFileTest {

	@Test
	public void findTest() {
		MFile file = new MFileImpl(new File("/home/jcruz/git/jtools/jtools.commons/"));
		MFile file2 = file.find("/src/test/java/persistence.xml");
		
		System.out.println(file2.getFile().getAbsolutePath());
	}
	
	@Test
	public void filterTest() {
		MFile file = new MFileImpl(new File("/opt/workspace-luna/aelis2016"));
		TCollection<MFile> cssFiles = file.find("/src/main/webapp/").filter(new FilterCSSFile(), TrueFileFilter.INSTANCE);
		System.out.println(cssFiles);
		System.out.println(cssFiles.size());
	}
}
