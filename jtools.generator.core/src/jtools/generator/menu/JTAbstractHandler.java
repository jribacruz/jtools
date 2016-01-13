package jtools.generator.menu;

import jtools.generator.context.JTContext;
import jtools.generator.dialog.JTDialog;
import jtools.generator.dialog.ProjectListSelectionDialog;

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
		JTDialog dialog = new ProjectListSelectionDialog();
		dialog.open(window);
		execute();
		return null;
	}

	public abstract void execute();

	public IProject getSelectedProject() {
		return JTContext.getCurrentInstance().getSelectedProject();
	}

}
