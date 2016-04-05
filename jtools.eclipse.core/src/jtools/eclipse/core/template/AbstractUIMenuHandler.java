package jtools.eclipse.core.template;

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
public abstract class AbstractUIMenuHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (onBeforeOpenWizard()) {
			WizardDialog dialog = new WizardDialog(window.getShell(), getWizard());
			dialog.open();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	protected boolean onBeforeOpenWizard() {
		return true;
	}

	/**
	 * 
	 * @return
	 */
	protected abstract AbstractUIWizard getWizard();

}
