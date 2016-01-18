package jtools.generator.eclipse.ui.dialog;

import org.eclipse.jface.wizard.Wizard;

public class GeneratorWizard extends Wizard {

	private GeneratorPropertiesPage page1;

	@Override
	public void addPages() {
		this.page1 = new GeneratorPropertiesPage("page1");
		addPage(page1);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
