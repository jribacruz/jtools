package jtools.generator.eclipse.ui.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class JTGeneratorPropertiesPage extends WizardPage {

	private Composite container;

	public static String projectName;

	protected JTGeneratorPropertiesPage(String pageName) {
		super(pageName);
		this.setTitle("Criar Gerador JTools");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Nome do projeto");

		Text textProjectName = new Text(container, SWT.BORDER | SWT.SINGLE);
		textProjectName.setText("");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		textProjectName.setLayoutData(gd);

		setControl(container);
		setPageComplete(false);

	}

}
