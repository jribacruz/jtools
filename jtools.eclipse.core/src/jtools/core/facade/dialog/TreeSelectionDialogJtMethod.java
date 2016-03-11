package jtools.core.facade.dialog;

import jtools.core.dialog.JtTreeSelectionDialog;
import jtools.core.model.JtModel;
import jtools.core.provider.JtModelLabelProvider;
import jtools.core.provider.JtModelMethodTreeContentProvider;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

public class TreeSelectionDialogJtMethod extends JtTreeSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JtModel model;

	public TreeSelectionDialogJtMethod(IWorkbenchWindow window, JtModel model) {
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