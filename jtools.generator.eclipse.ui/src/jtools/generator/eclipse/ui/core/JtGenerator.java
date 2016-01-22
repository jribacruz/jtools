package jtools.generator.eclipse.ui.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import jtools.generator.eclipse.ui.context.Context;

import org.apache.commons.lang3.StringUtils;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

public class JtGenerator {

	public static JtTemplate load(String name) throws URISyntaxException, IOException {
		if (StringUtils.isNotEmpty(name)) {
			File template = Context.getCurrentInstance().load("templates/" + name);
			JtwigTemplate jtwigTemplate = new JtwigTemplate(template, new JtwigConfiguration());
			JtTemplate JtTemplate = new JtTemplate(jtwigTemplate);
			return JtTemplate;
		}
		return new JtTemplate();
	}
}
