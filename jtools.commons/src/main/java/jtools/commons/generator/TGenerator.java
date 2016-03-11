package jtools.commons.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

import jtools.commons.internal.generator.TGeneratorJavaUpdaterImpl;
import jtools.commons.internal.generator.TGeneratorWriterImpl;
import jtools.commons.model.TMJava;

/**
 * 
 * Classe responsavel por gerar ou atualizar os artefatos (Java/XML).
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

	/**
	 * 
	 * @param javaModel
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static <T extends TMJava> TGeneratorJavaUpdater load(T javaModel) throws FileNotFoundException {
		return new TGeneratorJavaUpdaterImpl(javaModel.getFile());
	}

}
