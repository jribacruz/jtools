package jtools.core.dialog;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import jtools.core.listener.FinishListener;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ListSelectionDialog;

public abstract class JtCheckboxSelectionDialog<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IWorkbenchWindow window;

	private ListSelectionDialog dialog;
	private FinishListener finishListener;

	private String message = "Selecione uma String (* = any string, ? = any char):";

	public JtCheckboxSelectionDialog(IWorkbenchWindow window) {
		super();
		this.window = window;
	}

	protected void init() {

	}

	protected void finish() {

	}

	public abstract String getTitle();

	protected abstract T[] getList();

	protected abstract LabelProvider getLabelProvider();

	public void open() {
		if (window != null) {
			init();
			this.dialog = new ListSelectionDialog(window.getShell(), getList(), new ArrayContentProvider(), getLabelProvider(), getTitle());
			this.dialog.open();
			finish();
			if (this.finishListener != null) {
				this.finishListener.onFinish();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getResult() {
		return (List<T>) Arrays.asList(this.dialog.getResult());
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
}
