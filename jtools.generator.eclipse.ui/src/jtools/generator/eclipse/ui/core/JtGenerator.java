package jtools.generator.eclipse.ui.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import jtools.core.facade.Jt;
import jtools.generator.eclipse.ui.Activator;

import org.apache.commons.lang3.StringUtils;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

public class JtGenerator {

	/**
	 * Carrega um template.
	 * 
	 * @param name
	 *            Nome do Template.
	 * @return Objeto JtTemplate.
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static JtTemplate load(String name) throws URISyntaxException, IOException {
		if (StringUtils.isNotEmpty(name)) {
			File template = Jt.UTIL.getFile(Activator.PLUGIN_ID, "templates/" + name);
			JtwigTemplate jtwigTemplate = new JtwigTemplate(template, new JtwigConfiguration());
			JtTemplate JtTemplate = new JtTemplate(jtwigTemplate);
			return JtTemplate;
		}
		return new JtTemplate();
	}
}
