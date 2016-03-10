package jtools.commons.generator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;

import jtools.commons.internal.generator.TGeneratorWriterImpl;
import jtools.commons.model.TJavaModel;
import jtools.commons.model.TXMLModel;

import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;

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
	 */
	public static <T extends TJavaModel> TGeneratorJavaUpdater load(T javaModel) {
		return null;
	}

	/**
	 * 
	 * @param xmlModel
	 * @return
	 */
	public static <T extends TXMLModel> TGeneratorXMLUpdater load(T xmlModel) {
		return null;
	}

}
