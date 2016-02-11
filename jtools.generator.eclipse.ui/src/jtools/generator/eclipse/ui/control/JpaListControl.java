package jtools.generator.eclipse.ui.control;

import java.util.ArrayList;

import jtools.generator.eclipse.ui.context.JtConsole;
import jtools.generator.eclipse.ui.core.JtControl;
import jtools.generator.eclipse.ui.dialog.custom.list.ElementListSelectionDialogJpaEntity;
import jtools.generator.eclipse.ui.dialog.event.ChangeListener;
import jtools.generator.eclipse.ui.dialog.event.FinishListener;
import jtools.generator.eclipse.ui.model.JtModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchWindow;

public class JpaListControl extends JtControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Button addButton;

	private Button removeButton;

	private List jpaList;

	private Composite container;

	private ElementListSelectionDialogJpaEntity dialogJpaEntity;

	private IWorkbenchWindow window;

	private IProject project;

	private java.util.List<JtModel> jpaEntityModels = new ArrayList<>();

	private ChangeListener changeListener;

	public JpaListControl(IProject project, IWorkbenchWindow window, Composite container) {
		super();
		this.project = project;
		this.container = container;
		this.window = window;
		createControl();
	}

	@Override
	protected void createControl() {

		Label label = new Label(container, SWT.NONE);
		label.setText("Entidades:");

		this.jpaList = new List(container, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);

		Composite buttonsComposite = new Composite(container, SWT.NONE);
		GridLayout layout2 = new GridLayout();
		buttonsComposite.setLayout(layout2);
		layout2.numColumns = 1;

		this.addButton = new Button(buttonsComposite, SWT.PUSH);
		this.addButton.setText("Adicionar...");
		this.addButton.addMouseListener(new AddButtonMouseListener());

		this.removeButton = new Button(buttonsComposite, SWT.PUSH);
		this.removeButton.setText("Remover");
		this.removeButton.setEnabled(this.jpaEntityModels.size() > 0);
		this.removeButton.addMouseListener(new RemoveButtonMouseListener());

		this.dialogJpaEntity = new ElementListSelectionDialogJpaEntity(this.project, this.window);
		this.dialogJpaEntity.addFinishListener(new DialogJpaFinishListener());

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		jpaList.setLayoutData(gd);

	}

	public java.util.List<JtModel> getSelections() {
		return this.jpaEntityModels;
	}

	public void addChangeListener(ChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	private class AddButtonMouseListener implements MouseListener {

		@Override
		public void mouseDoubleClick(MouseEvent arg0) {

		}

		@Override
		public void mouseDown(MouseEvent arg0) {
			dialogJpaEntity.selectedList(jpaEntityModels);
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
			JtConsole.log("Entidade Selecionadas %s", jpaModel.getName());
			jpaEntityModels.add(jpaModel);
			jpaList.add(jpaModel.getFullyQualifiedName());
			removeButton.setEnabled(jpaEntityModels.size() > 0);
			if (changeListener != null) {
				changeListener.onChange();
			}
		}

	}

	private class RemoveButtonMouseListener implements MouseListener {

		@Override
		public void mouseDoubleClick(MouseEvent arg0) {

		}

		@Override
		public void mouseDown(MouseEvent arg0) {
			JtConsole.log("Index da entidade selecionada: %d", jpaList.getSelectionIndex());
			jpaEntityModels.remove(jpaList.getSelectionIndex());
			jpaList.remove(jpaList.getSelectionIndex());
			removeButton.setEnabled(jpaEntityModels.size() > 0);
			if (changeListener != null) {
				changeListener.onChange();
			}
		}

		@Override
		public void mouseUp(MouseEvent arg0) {

		}

	}

}
