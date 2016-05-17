package jtools.eclipse.core.generator;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

public class GeneratorWizardPage<T extends GeneratorModel> extends WizardPage {

	private T model;

	protected GeneratorWizardPage(String pageName, T model) {
		super(pageName);
		this.model = model;
	}

	@Override
	public void createControl(Composite parent) {

	}

}
