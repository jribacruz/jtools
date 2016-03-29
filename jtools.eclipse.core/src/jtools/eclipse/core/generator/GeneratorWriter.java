package jtools.eclipse.core.generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import jtools.eclipse.core.model.JxJavaClass;

import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

public interface GeneratorWriter extends Serializable {
	/**
	 * 
	 * @param model
	 * @return
	 */
	public <T extends JxJavaClass> GeneratorWriter model(T model);

	/**
	 * 
	 * @param context
	 * @return
	 */
	public GeneratorWriter context(Map<String, Object> context);

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public GeneratorWriter put(String key, Object value);

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
