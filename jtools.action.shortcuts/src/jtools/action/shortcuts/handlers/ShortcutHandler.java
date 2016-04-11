package jtools.action.shortcuts.handlers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import jtools.action.shortcuts.Activator;
import jtools.action.shortcuts.preferences.PreferenceConstants;
import jtools.action.shortcuts.wizards.SampleNewWizard;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ShortcutHandler extends AbstractHandler  {
	/**
	 * The constructor.
	 */
	public ShortcutHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {


		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);


		SampleNewWizard wiz = new SampleNewWizard();


	      // Create the wizard dialog
	      WizardDialog dialog = new WizardDialog(window.getShell(), wiz);
	      // Open the wizard dialog
	      dialog.create();
	      dialog.setBlockOnOpen(true);
	      dialog.open();
		
		

		return null;
	}
}
