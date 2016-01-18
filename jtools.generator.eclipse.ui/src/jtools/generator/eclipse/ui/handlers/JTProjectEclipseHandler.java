package jtools.generator.eclipse.ui.handlers;

import jtools.generator.eclipse.ui.dialog.GeneratorDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * @author jcruz
 *
 */
public class JTProjectEclipseHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		WizardDialog dialog = new WizardDialog(window.getShell(), new GeneratorDialog());
		dialog.open();
		return null;
	}
}
