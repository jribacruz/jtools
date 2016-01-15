package jtools.generator.eclipse.ui.dialog;

import org.eclipse.jface.wizard.Wizard;

public class JTGeneratorDialog extends Wizard {

	private JTGeneratorPropertiesPage page1;

	@Override
	public void addPages() {
		this.page1 = new JTGeneratorPropertiesPage("page1");
		addPage(page1);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
