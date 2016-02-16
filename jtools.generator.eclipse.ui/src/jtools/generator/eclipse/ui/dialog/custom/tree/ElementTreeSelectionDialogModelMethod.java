package jtools.generator.eclipse.ui.dialog.custom.tree;

import jtools.eclipse.core.model.JtModel;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractTreeListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.content.JtModelMethodTreeContentProvider;
import jtools.generator.eclipse.ui.dialog.providers.label.JtModelLabelProvider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

public class ElementTreeSelectionDialogModelMethod extends JtAbstractTreeListSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JtModel model;

	public ElementTreeSelectionDialogModelMethod(IWorkbenchWindow window, JtModel model) {
		super(window);
		this.model = model;
	}

	@Override
	public String getTitle() {
		return "Selecione um método do modelo";
	}

	@Override
	protected JtModel[] getList() {
		return new JtModel[] { this.model };
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}

	@Override
	protected ITreeContentProvider getContentProvider() {
		return new JtModelMethodTreeContentProvider();
	}

}
