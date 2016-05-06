package jtools.eclipse.core.generator;

import org.eclipse.jface.wizard.Wizard;

public class GeneratorWizard<T extends GeneratorModel> extends Wizard {

	@Override
	public boolean performFinish() {
		return false;
	}

}
