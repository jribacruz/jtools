package jtools.generator.eclipse.ui.control;

import java.util.Arrays;

import jtools.eclipse.core.facade.Jt;
import jtools.eclipse.core.model.JtModel;
import jtools.generator.eclipse.ui.core.JtControl;
import jtools.generator.eclipse.ui.dialog.custom.list.ElementListSelectionDialogJpaEntity;
import jtools.generator.eclipse.ui.dialog.event.ChangeListener;
import jtools.generator.eclipse.ui.dialog.event.FinishListener;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;

public class JpaControl extends JtControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Button selectButton;

	private Text jpaText;

	private Composite container;

	private ElementListSelectionDialogJpaEntity dialogJpaEntity;

	private IWorkbenchWindow window;

	private IProject project;

	private JtModel jpaEntityModel;

	private ChangeListener changeListener;

	public JpaControl(IProject project, IWorkbenchWindow window, Composite container) {
		super();
		this.project = project;
		this.container = container;
		this.window = window;
		createControl();
	}

	@Override
	protected void createControl() {

		Label label = new Label(container, SWT.NONE);
		label.setText("Entidade:");

		this.jpaText = new Text(container, SWT.BORDER);
		this.jpaText.setEditable(false);

		Composite buttonsComposite = new Composite(container, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		buttonsComposite.setLayout(layout2);
		layout2.numColumns = 1;

		this.selectButton = new Button(buttonsComposite, SWT.PUSH);
		this.selectButton.setText("Selecionar...");
		this.selectButton.addMouseListener(new SelectButtonMouseListener());

		this.dialogJpaEntity = new ElementListSelectionDialogJpaEntity(this.project, this.window);
		this.dialogJpaEntity.addFinishListener(new DialogJpaFinishListener());

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		jpaText.setLayoutData(gd);

	}

	public JtModel getSelection() {
		return this.jpaEntityModel;
	}

	public void addChangeListener(ChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	private class SelectButtonMouseListener implements MouseListener {

		@Override
		public void mouseDoubleClick(MouseEvent arg0) {

		}

		@Override
		public void mouseDown(MouseEvent arg0) {
			if (jpaEntityModel != null) {
				dialogJpaEntity.selectedList(Arrays.asList(jpaEntityModel));
			}
			dialogJpaEntity.open();
		}

		@Override
		public void mouseUp(MouseEvent arg0) {

		}

	}

	private class DialogJpaFinishListener implements FinishListener {

		@Override
		public void onFinish() {
			JtModel jpaModel = dialogJpaEntity.getResult();
			Jt.CONSOLE.log("Entidade Selecionadas %s", jpaModel.getName());
			jpaEntityModel = jpaModel;
			jpaText.setText(jpaModel.getFullyQualifiedName());
			if (changeListener != null) {
				changeListener.onChange();
			}
		}

	}

}
