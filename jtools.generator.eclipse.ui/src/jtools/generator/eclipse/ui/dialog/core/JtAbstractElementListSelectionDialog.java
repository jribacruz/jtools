package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.dialog.event.FinishListener;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public abstract class JtAbstractElementListSelectionDialog<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IWorkbenchWindow window;

	private ElementListSelectionDialog dialog;

	private FinishListener finishListener;

	private List<T> selectedList;

	private String message = "Selecione uma String (* = any string, ? = any char):";

	public JtAbstractElementListSelectionDialog(IWorkbenchWindow window) {
		super();
		this.window = window;
	}

	protected void init() {

	}

	protected void finish() {

	}

	public abstract String getTitle();

	protected abstract T[] getList();

	public void selectedList(List<T> selectedList) {
		this.selectedList = selectedList;
	}

	protected abstract LabelProvider getLabelProvider();

	public void open() {
		if (window != null) {
			init();
			this.dialog = new ElementListSelectionDialog(window.getShell(), getLabelProvider());
			this.dialog.setTitle(getTitle());
			this.dialog.setMessage(message);
			this.dialog.setElements(getList());
			this.dialog.open();
			finish();
			if (this.finishListener != null) {
				this.finishListener.onFinish();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public T getResult() {
		return (T) this.dialog.getFirstResult();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	protected IWorkbenchWindow getWorkbenchWindow() {
		return this.window;
	}

	public void addFinishListener(FinishListener finishListener) {
		this.finishListener = finishListener;
	}

	public List<T> getSelectedList() {
		if (this.selectedList == null) {
			this.selectedList = new ArrayList<>();
		}
		return selectedList;
	}

}
