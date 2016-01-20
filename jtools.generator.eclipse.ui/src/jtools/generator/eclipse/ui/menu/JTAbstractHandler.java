package jtools.generator.eclipse.ui.menu;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.Dialog;
import jtools.generator.eclipse.ui.dialog.ProjectListSelectionDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class JTAbstractHandler extends AbstractHandler {

	/**
	 * 
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Dialog dialog = new ProjectListSelectionDialog();
		dialog.open(window);
		execute();
		return null;
	}

	public abstract void execute();

	public IProject getSelectedProject() {
		return Context.getCurrentInstance().getSelectedProject();
	}

}
