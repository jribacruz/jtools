package jtools.commons.generator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

import jtools.commons.internal.generator.GeneratorWriterImpl;

/**
 * 
 * Classe responsavel por gerar os artefatos (Java/XML/Others).
 * 
 * @author jcruz
 *
 */
public class Generator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6528052143192773070L;

	/**
	 * 
	 * @param template
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static GeneratorWriter load(File template) throws URISyntaxException, IOException {
		JtwigTemplate jtwigTemplate = new JtwigTemplate(template, new JtwigConfiguration());
		GeneratorWriter JtTemplate = new GeneratorWriterImpl(jtwigTemplate);
		return JtTemplate;
	}

}
