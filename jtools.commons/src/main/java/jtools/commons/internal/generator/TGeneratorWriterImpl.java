package jtools.commons.internal.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import jtools.commons.generator.TGeneratorWriter;
import jtools.commons.model.java.TJavaModel;

import com.lyncode.jtwig.JtwigModelMap;
import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

public class TGeneratorWriterImpl implements TGeneratorWriter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JtwigTemplate template;

	private JtwigModelMap context;

	public TGeneratorWriterImpl(JtwigTemplate jtwigTemplate) {
		this.template = jtwigTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.generator.TGeneratorWriter#model(jtools.commons.model.
	 * TJavaModel)
	 */
	@Override
	public <T extends TJavaModel> TGeneratorWriter model(T model) {
		getContext().add("model", model);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.generator.TGeneratorWriter#context(java.util.Map)
	 */
	@Override
	public TGeneratorWriter context(Map<String, Object> context) {
		getContext().add(context);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.generator.TGeneratorWriter#add(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public TGeneratorWriter add(String key, Object value) {
		getContext().put(key, value);
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.generator.TGeneratorWriter#write(java.lang.String)
	 */
	@Override
	public void write(String path) throws ParseException, CompileException, RenderException, IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		this.template.output(outputStream, getContext());
		outputStream.flush();
		outputStream.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.generator.TGeneratorWriter#write()
	 */
	@Override
	public String write() throws ParseException, CompileException, RenderException {
		return this.template.output(getContext());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.generator.TGeneratorWriter#write(java.lang.String,
	 * boolean)
	 */
	@Override
	public void write(String path, boolean append) throws ParseException, CompileException, RenderException, IOException {
		FileOutputStream outputStream = new FileOutputStream(new File(path), append);
		this.template.output(outputStream, getContext());
		outputStream.flush();
		outputStream.close();
	}

	private JtwigModelMap getContext() {
		if (this.context == null) {
			this.context = new JtwigModelMap();
		}
		return this.context;
	}

}
