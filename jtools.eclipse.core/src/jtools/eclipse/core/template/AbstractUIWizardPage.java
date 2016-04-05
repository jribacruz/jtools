package jtools.eclipse.core.template;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import jtools.eclipse.core.helper.UIToolkit;

/**
 * 
 * @author jcruz
 *
 */
public class AbstractUIWizardPage extends WizardPage {

	private UIToolkit toolkit;

	public AbstractUIWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	protected AbstractUIWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite arg0) {
	}

	protected void setUIToolkit(UIToolkit toolkit) {
		this.toolkit = toolkit;
	}

}
