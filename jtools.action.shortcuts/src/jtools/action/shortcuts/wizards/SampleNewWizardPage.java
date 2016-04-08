package jtools.action.shortcuts.wizards;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

import jtools.action.shortcuts.Activator;
import jtools.action.shortcuts.preferences.PreferenceConstants;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (mpe).
 */

public class SampleNewWizardPage extends WizardPage {


	private ISelection selection;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public SampleNewWizardPage(ISelection selection) {
		super("wizardPage");
		setTitle("Jtools Shortcuts");
		setDescription("Clique sobre um dos links abaixo para abrir");
		this.selection = selection;
	}

	public void createControl(Composite parent) {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();

		String url = store.getString(PreferenceConstants.P_URL);

		String[] urls = StringUtils.split(url, ";");


		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
	
		

		for (int i = 0; i < urls.length; i++) {
			Label label = new Label(container, SWT.NULL);
					label.setText(urls[i]);

		}

		
	
		setControl(container);
		setPageComplete(false);
	}

}