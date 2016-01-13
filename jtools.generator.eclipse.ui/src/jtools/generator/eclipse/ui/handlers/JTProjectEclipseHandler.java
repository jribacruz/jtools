package jtools.generator.eclipse.ui.handlers;

import jtools.generator.context.JTContext;
import jtools.generator.context.MessageContext;
import jtools.generator.context.MessageContext.SeverityType;
import jtools.generator.dialog.ProjectListSelectionDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
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

		ProjectListSelectionDialog dialog = new ProjectListSelectionDialog();
		dialog.open(window);

		MessageContext.add("Projeto Selecionado", SeverityType.INFO, JTContext.getCurrentInstance().getSelectedProject().getName());

		return null;
	}

}
