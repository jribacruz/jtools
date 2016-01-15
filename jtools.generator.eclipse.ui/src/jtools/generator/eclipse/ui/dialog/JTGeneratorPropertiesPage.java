package jtools.generator.eclipse.ui.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class JTGeneratorPropertiesPage extends WizardPage {

	private Composite container;

	private Text textProjectName;

	public static final String JT_GEN_PROJECT_NAME = "jtools.generator.project.name";

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
		
		Label labelProjectName = new Label(container, SWT.NONE);
		labelProjectName.setText("Nome do projeto");

		textProjectName = new Text(container, SWT.BORDER | SWT.SINGLE);
		textProjectName.setText("");
		textProjectName.addKeyListener(new TextProjectNameKeyListener());

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		textProjectName.setLayoutData(gd);

		setControl(container);
		setPageComplete(false);

	}

	public String getProjectName() {
		return textProjectName.getText();
	}

	/**
	 * 
	 * @author jcruz
	 *
	 */
	protected class TextProjectNameKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if (!((Text) arg0.getSource()).getText().isEmpty()) {
				setPageComplete(true);
				return;
			}
			setPageComplete(false);
		}

	}

}
