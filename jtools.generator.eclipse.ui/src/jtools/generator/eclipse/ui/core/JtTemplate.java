package jtools.generator.eclipse.ui.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jtools.generator.eclipse.ui.context.MessageContext;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;

import com.lyncode.jtwig.JtwigModelMap;
import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

public class JtTemplate {

	private JtwigTemplate template;

	private JtwigModelMap map;

	public JtTemplate() {
		super();
	}

	public JtTemplate(JtwigTemplate template) {
		super();
		this.template = template;
	}

	/**
	 * Add
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public JtTemplate put(String key, Object value) {
		if (this.map == null) {
			this.map = new JtwigModelMap();
		}
		this.map.put(key, value);
		return this;
	}

	/**
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void write(String... path) throws FileNotFoundException, ParseException, CompileException, RenderException {
		FileOutputStream outputStream = new FileOutputStream(new File(StringUtils.join(path)));
		this.template.output(outputStream, map);
	}

	/**
	 * 
	 * @param project
	 * @param path
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void write(IProject project, String... path) throws FileNotFoundException, ParseException, CompileException, RenderException {
		String cpath = project.getLocation().toString() + StringUtils.join(path);
		MessageContext.printlnConsole("[JtTemplate] Criando arquivo %s ", cpath);
		FileOutputStream outputStream = new FileOutputStream(new File(cpath));
		MessageContext.printlnConsole("[JtTemplate] Write/Merge template ");
		this.template.output(outputStream, map);
	}

}
