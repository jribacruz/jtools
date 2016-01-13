package jtools.generator.dialog;

import jtools.generator.context.JTContext;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;

public class ProjectListSelectionDialog {

	public ProjectListSelectionDialog() {
		super();
	}

	public void open(IWorkbenchWindow window) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new ProjectLabelProvider());
		dialog.setTitle("Selecione um projeto");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(projects);
		dialog.open();
		IProject selectedProject = (IProject) dialog.getFirstResult();
		JTContext.getCurrentInstance().setSelectedProject(selectedProject);
	}

	protected class ProjectLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
		}

		@Override
		public String getText(Object element) {
			IProject project = (IProject) element;
			return project.getName();
		}

	}

}
