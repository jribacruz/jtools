package jtools.generator.eclipse.ui.handlers;

import jtools.generator.context.JTContext;
import jtools.generator.dialog.ProjectListSelectionDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * @author jcruz
 *
 */
public class JTProjectEclipseHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public JTProjectEclipseHandler() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands
	 * .ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		/*
		 * IStructuredSelection selection = (IStructuredSelection)
		 * window.getSelectionService().getSelection(); if (selection != null) {
		 * Object firstElement = selection.getFirstElement(); if (firstElement
		 * instanceof IAdaptable) { IProject project =
		 * (IProject)((IAdaptable)firstElement).getAdapter(IProject.class);
		 * IPath path = project.getFullPath(); System.out.println(path);
		 * MessageDialog.openInformation(window.getShell(), "Ui",
		 * path.toString()); } }
		 */

		ProjectListSelectionDialog dialog = new ProjectListSelectionDialog();
		dialog.open(window);

		MessageDialog.openInformation(window.getShell(), "Projeto Selecionado", JTContext.getCurrentInstance().getSelectedProject().getName());

		return null;
	}

}
