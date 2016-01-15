package jtools.generator.context;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import jtools.generator.context.MessageContext.SeverityType;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class JTContext {

	private static JTContext instance = null;

	private IProject selectedProject;

	private JTContext() {

	}

	public static JTContext getCurrentInstance() {
		if (instance == null) {
			instance = new JTContext();
		}
		return instance;
	}

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

}
