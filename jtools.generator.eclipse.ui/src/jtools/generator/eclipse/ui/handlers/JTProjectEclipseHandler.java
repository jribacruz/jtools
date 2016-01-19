package jtools.generator.eclipse.ui.handlers;

import java.io.File;

import jtools.generator.context.Context;
import jtools.generator.context.MessageContext;
import jtools.generator.eclipse.ui.Activator;
import jtools.generator.eclipse.ui.dialog.GeneratorWizard;

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
		/*
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		WizardDialog dialog = new WizardDialog(window.getShell(), new GeneratorWizard());
		dialog.open();
			*/
		File file = Context.getCurrentInstance().load(Activator.PLUGIN_ID, "templates/Activator.vm");
		
		MessageContext.add("Msg", file.getAbsolutePath());
		
		return null;
	}
}
