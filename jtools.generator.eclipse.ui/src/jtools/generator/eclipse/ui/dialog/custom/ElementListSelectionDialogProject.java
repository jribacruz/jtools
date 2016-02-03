package jtools.generator.eclipse.ui.dialog.custom;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.providers.ProjectLabelProvider;
import jtools.generator.eclipse.ui.dialog.template.Dialog;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * 
 * Classe responsável por listar todos os projeto do workspace.
 * 
 * @author jcruz
 *
 */
public class ElementListSelectionDialogProject implements Dialog {

	public ElementListSelectionDialogProject() {
		super();
	}

	/**
	 * Abre o dialog.
	 */
	@Override
	public void open(IWorkbenchWindow window) {
		// Retorna a lista de projetos do workspace.
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new ProjectLabelProvider());
		dialog.setTitle("Selecione um projeto");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(projects);
		dialog.open();
		// Retorna o projeto selecionado.
		IProject selectedProject = (IProject) dialog.getFirstResult();
		// Armazena o projeto selecionado no contexto.
		Context.getCurrentInstance().setSelectedProject(selectedProject);
	}

}
