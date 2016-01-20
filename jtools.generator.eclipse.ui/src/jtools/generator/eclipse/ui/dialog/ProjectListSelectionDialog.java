package jtools.generator.eclipse.ui.dialog;

import jtools.generator.eclipse.ui.context.Context;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.ide.IDE;

/**
 * 
 * Classe responsável por listar todos os projeto do workspace.
 * 
 * @author jcruz
 *
 */
public class ProjectListSelectionDialog implements Dialog {

	public ProjectListSelectionDialog() {
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

	/**
	 * LabelProvider Implementation
	 * 
	 * @author jcruz
	 *
	 */
	protected class ProjectLabelProvider extends LabelProvider {

		/**
		 * Retorna o icone padrão de um projeto.
		 */
		@Override
		public Image getImage(Object element) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
		}

		/**
		 * Retorna o nome do projeto no workspace.
		 */
		@Override
		public String getText(Object element) {
			IProject project = (IProject) element;
			return project.getName();
		}

	}

}
