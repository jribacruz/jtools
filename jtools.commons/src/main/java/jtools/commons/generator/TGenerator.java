package jtools.commons.generator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

import jtools.commons.internal.generator.TGeneratorWriterImpl;

/**
 * 
 * Classe responsavel por gerar os artefatos (Java/XML/Others).
 * 
 * @author jcruz
 *
 */
public class TGenerator implements Serializable {

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
	public static TGeneratorWriter load(File template) throws URISyntaxException, IOException {
		JtwigTemplate jtwigTemplate = new JtwigTemplate(template, new JtwigConfiguration());
		TGeneratorWriter JtTemplate = new TGeneratorWriterImpl(jtwigTemplate);
		return JtTemplate;
	}

}
