package jtools.generator.context;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import jtools.generator.context.MessageContext.SeverityType;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

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
		if (selectedProject != null) {
			try {
				selectedProject.refreshLocal(IResource.DEPTH_ZERO, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * Carrega um arquivo armazenado do bundle.
	 * 
	 * @param bundleId
	 * @param location
	 * @return
	 */
	public File load(String bundleId, String location) {
		Bundle bundle = Platform.getBundle(bundleId);
		URL fileURL = bundle.getEntry(location);
		File file = null;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
		} catch (URISyntaxException e1) {
			MessageContext.add("Aviso", SeverityType.ERROR, "Arquivo não encontrado: " + location);
		} catch (IOException e1) {
			MessageContext.add("Aviso", SeverityType.ERROR, "Erro ao abrir arquivo: " + location);
		}
		return file;
	}

	public Object get(String key) {
		return this.map.get(key);
	}

	public void put(String key, Object value) {
		this.map.put(key, value);
	}

}
