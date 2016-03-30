package jtools.eclipse.core.ui;

import jtools.eclipse.core.util.Reflections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 * @author jcruz
 *
 */
public abstract class UIWizardHandler<X extends UIWizard> extends AbstractHandler {

	private Shell shell;

	/**
	 * 
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		this.shell = window.getShell();
		if (onBeforeOpenWizard()) {
			openWizard();
		}
		return null;
	}

	protected abstract Class<X> getWizardClass();

	protected void openWizard() {
		Wizard wizard = getWizardInstance();
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.open();
	}

	/**
	 * 
	 * @return
	 */
	protected boolean onBeforeOpenWizard() {
		return true;
	}

	private Wizard getWizardInstance() {
		return Reflections.getInstance(getWizardClass());
	}

}
