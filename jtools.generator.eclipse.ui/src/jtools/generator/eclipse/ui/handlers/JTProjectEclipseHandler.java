package jtools.generator.eclipse.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * 
 * @author jcruz
 *
 */
public class JTProjectEclipseHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		/*
		 * IWorkbenchWindow window =
		 * HandlerUtil.getActiveWorkbenchWindowChecked(event); WizardDialog
		 * dialog = new WizardDialog(window.getShell(), new GeneratorWizard());
		 * dialog.open();
		 */
		// File file = Context.getCurrentInstance().load(Activator.PLUGIN_ID,
		// "templates/Activator.vm");

		// MessageContext.add("Msg", file.getAbsolutePath());

		return null;
	}
}
