package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ListSelectionDialog;

public abstract class JtAbstractListSelectionDialog<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IWorkbenchWindow window;

	private ListSelectionDialog dialog;

	private String message = "Selecione uma String (* = any string, ? = any char):";

	public JtAbstractListSelectionDialog(IWorkbenchWindow window) {
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
}
