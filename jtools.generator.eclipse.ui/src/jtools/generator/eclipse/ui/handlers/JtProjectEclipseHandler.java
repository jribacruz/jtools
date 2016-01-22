package jtools.generator.eclipse.ui.handlers;

import jtools.generator.eclipse.ui.dialog.helper.JpaEntityListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.helper.ProjectListSelectionDialog;

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
public class JtProjectEclipseHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		/*
		 * WizardDialog dialog = new WizardDialog(window.getShell(), new
		 * GeneratorWizard()); dialog.open();
		 */

		ProjectListSelectionDialog listSelectionDialog = new ProjectListSelectionDialog();
		listSelectionDialog.open(window);

		JpaEntityListSelectionDialog dialog = new JpaEntityListSelectionDialog();
		dialog.open(window);

		return null;
	}
}
