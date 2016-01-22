package jtools.generator.eclipse.ui.context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.Model;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.lyncode.jtwig.JtwigModelMap;
import com.lyncode.jtwig.JtwigTemplate;
import com.lyncode.jtwig.configuration.JtwigConfiguration;
import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

/**
 * Classe singleton que guarda o contexto do projeto.
 * 
 * @author jcruz
 *
 */
public class Context {

	private static Context instance = null;

	private IProject selectedProject;

	private Map<String, Object> map = new HashMap<String, Object>();
	
	private String bundleId;

	private Context() {

	}

	public static Context getCurrentInstance() {
		if (instance == null) {
			instance = new Context();
		}
		return instance;
	}

	/**
	 * Retorna o projeto selecionado.
	 * 
	 * @return
	 */
	public IProject getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}

	/**
	 * Atualiza o projeto selecionado.
	 */
	public void refreshSelectedProject() {
		ProjectHelper.refreshProject(getSelectedProject());
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public boolean isDirectory(String path) {
		return new File(FilenameUtils.getFullPath(path)).isDirectory();
	}

	/**
	 * 
	 * @param path
	 */
	public void mkdirs(String path) {
		if (!StringUtils.isEmpty(path)) {
			new File(path).mkdirs();
		}
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	public boolean exists(String file) {
		return new File(file).isFile();
	}

	/**
	 * 
	 * Carrega um arquivo armazenado do bundle.
	 * 
	 * @param bundleId
	 * @param location
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public File load(String bundleId, String location) throws URISyntaxException, IOException {
		Bundle bundle = Platform.getBundle(bundleId);
		URL fileURL = bundle.getEntry(location);
		File file = new File(FileLocator.resolve(fileURL).toURI());
		return file;
	}
	
	public File load(String location) throws URISyntaxException, IOException {
		if(StringUtils.isNotEmpty(bundleId)) {
			Bundle bundle = Platform.getBundle(bundleId);
			URL fileURL = bundle.getEntry(location);
			File file = new File(FileLocator.resolve(fileURL).toURI());
			return file;
		}
		return null;
	}
	
	public void setBundleId(String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * 
	 * @param template
	 * @param path
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void generate(File template, String path) throws FileNotFoundException, ParseException, CompileException, RenderException {
		JtwigTemplate t = new JtwigTemplate(template, new JtwigConfiguration());
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		t.output(outputStream, new JtwigModelMap());
	}

	/**
	 * 
	 * @param template
	 * @param path
	 * @param map
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void generate(File template, String path, Map<String, Object> map) throws FileNotFoundException, ParseException,
			CompileException, RenderException {
		JtwigTemplate t = new JtwigTemplate(template, new JtwigConfiguration());
		JtwigModelMap modelMap = new JtwigModelMap();
		modelMap.add(map);
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		t.output(outputStream, modelMap);
	}

	/**
	 * 
	 * @param template
	 * @param path
	 * @param model
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void generate(File template, String path, Model model) throws FileNotFoundException, ParseException, CompileException,
			RenderException {
		JtwigTemplate t = new JtwigTemplate(template, new JtwigConfiguration());
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		JtwigModelMap modelMap = new JtwigModelMap();
		modelMap.add("model", model);
		t.output(outputStream, modelMap);
	}

	/**
	 * 
	 * @param template
	 * @param path
	 * @param model
	 * @param map
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws CompileException
	 * @throws RenderException
	 */
	public void generate(File template, String path, Model model, Map<String, Object> map) throws FileNotFoundException, ParseException,
			CompileException, RenderException {
		JtwigTemplate t = new JtwigTemplate(template, new JtwigConfiguration());
		FileOutputStream outputStream = new FileOutputStream(new File(path));
		JtwigModelMap modelMap = new JtwigModelMap();
		modelMap.add(map);
		modelMap.add("model", model);
		t.output(outputStream, modelMap);
	}

	public Object get(String key) {
		return this.map.get(key);
	}

	public void put(String key, Object value) {
		this.map.put(key, value);
	}

}
