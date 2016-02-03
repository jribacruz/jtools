package jtools.generator.eclipse.ui.dialog.custom;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractElementListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.ProjectLabelProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * 
 * Classe responsável por listar todos os projeto do workspace.
 * 
 * @author jcruz
 *
 */
public class ElementListSelectionDialogProject extends JtAbstractElementListSelectionDialog<IProject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementListSelectionDialogProject(IWorkbenchWindow window) {
		super(window);
	}

	@Override
	protected void init() {
	}

	@Override
	protected IProject[] getList() {
		return ResourcesPlugin.getWorkspace().getRoot().getProjects();
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new ProjectLabelProvider();
	}

	@Override
	protected void finish() {
		Context.getCurrentInstance().setSelectedProject(getResult());
	}

	@Override
	public String getTitle() {
		return "Selecione um projeto";
	}

}
