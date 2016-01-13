package jtools.generator.context;

import org.eclipse.core.resources.IProject;

public class JTContext {

	private static JTContext instance = null;

	private IProject selectedProject;

	private JTContext() {

	}

	public static JTContext getInstance() {
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

}
