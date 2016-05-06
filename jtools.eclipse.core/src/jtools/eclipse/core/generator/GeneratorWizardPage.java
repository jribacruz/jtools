package jtools.eclipse.core.generator;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class GeneratorWizardPage<T extends GeneratorModel> extends WizardPage {

	protected GeneratorWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {

	}

}
