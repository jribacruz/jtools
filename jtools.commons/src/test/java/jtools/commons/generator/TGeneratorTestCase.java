package jtools.commons.generator;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

@RunWith(JUnit4.class)
public class TGeneratorTestCase {

	@Test
	public void generatorWriterStringTest() throws ParseException, CompileException, RenderException, URISyntaxException, IOException {
		File template = new File("src/test/java/jtools/commons/template.jtwig");
		//@formatter:off
		String merge = TGenerator.load(template)
			.add("nome", "jcruz@gmail.com")
			.write();
		System.out.println(merge);
		Assert.assertNotNull("Sem merge", merge);
		//@formatter:on
	}

	@Test
	public void generatorWriterFileTest() throws ParseException, CompileException, RenderException, URISyntaxException, IOException {
		File template = new File("src/test/java/jtools/commons/template.jtwig");
		//@formatter:off
		TGenerator.load(template)
			.add("nome", "jcruz@gmail.com")
			.write("target/template-output.txt", true);
		//@formatter:on
	}
}
