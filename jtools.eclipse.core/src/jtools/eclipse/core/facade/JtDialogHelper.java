package jtools.eclipse.core.facade;

import java.io.Serializable;

import jtools.eclipse.core.facade.dialog.CheckboxSelectionDialogBC;
import jtools.eclipse.core.facade.dialog.CheckboxSelectionDialogDAO;
import jtools.eclipse.core.facade.dialog.CheckboxSelectionDialogEntity;
import jtools.eclipse.core.facade.dialog.SelectionDialogBC;
import jtools.eclipse.core.facade.dialog.SelectionDialogDAO;
import jtools.eclipse.core.facade.dialog.SelectionDialogEntity;
import jtools.eclipse.core.facade.dialog.TreeSelectionDialogJtMethod;
import jtools.eclipse.core.model.JtModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchWindow;

public class JtDialogHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public CheckboxSelectionDialogBC newCheckboxSelectionDialogBC(IProject project, IWorkbenchWindow window) {
		return new CheckboxSelectionDialogBC(project, window);
	}

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public CheckboxSelectionDialogDAO newCheckboxSelectionDialogDAO(IProject project, IWorkbenchWindow window) {
		return new CheckboxSelectionDialogDAO(project, window);
	}

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public CheckboxSelectionDialogEntity newCheckboxSelectionDialogEntity(IProject project, IWorkbenchWindow window) {
		return new CheckboxSelectionDialogEntity(project, window);
	}

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public SelectionDialogBC newSelectionDialogBC(IProject project, IWorkbenchWindow window) {
		return new SelectionDialogBC(project, window);
	}

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public SelectionDialogDAO newSelectionDialogDAO(IProject project, IWorkbenchWindow window) {
		return new SelectionDialogDAO(project, window);
	}

	/**
	 * 
	 * @param project
	 * @param window
	 * @return
	 */
	public SelectionDialogEntity newSelectionDialogEntity(IProject project, IWorkbenchWindow window) {
		return new SelectionDialogEntity(project, window);
	}

	/**
	 * 
	 * @param window
	 * @param model
	 * @return
	 */
	public TreeSelectionDialogJtMethod newTreeSelectionDialogJtMethod(IWorkbenchWindow window, JtModel model) {
		return new TreeSelectionDialogJtMethod(window, model);
	}
}
