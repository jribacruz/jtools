package jtools.eclipse.core.template;

import org.eclipse.jface.wizard.Wizard;

/**
 * 
 * @author jcruz
 *
 */
public class AbstractUIWizard extends Wizard {

	@Override
	public boolean performFinish() {
		return false;
	}

	protected <T extends AbstractUIWizardPage> void addWizardPage(T page) {
	}

}
