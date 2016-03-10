package jtools.commons.generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import jtools.commons.model.TJavaModel;

import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

public interface TGeneratorWriter extends Serializable {
	/**
	 * 
	 * @param model
	 * @return
	 */
	public <T extends TJavaModel> TGeneratorWriter model(T model);

	/**
	 * 
	 * @param context
	 * @return
	 */
	public TGeneratorWriter context(Map<String, Object> context);

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public TGeneratorWriter add(String key, Object value);

	/**
	 * @throws RenderException
	 * @throws CompileException
	 * @throws ParseException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 */
	public void write(String path) throws ParseException, CompileException, RenderException, FileNotFoundException, IOException;

	/**
	 * 
	 * @param path
	 * @param append
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void write(String path, boolean append) throws ParseException, CompileException, RenderException, FileNotFoundException,
			IOException;

	/**
	 * @throws RenderException
	 * @throws CompileException
	 * @throws ParseException
	 * 
	 */
	public String write() throws ParseException, CompileException, RenderException;

}
