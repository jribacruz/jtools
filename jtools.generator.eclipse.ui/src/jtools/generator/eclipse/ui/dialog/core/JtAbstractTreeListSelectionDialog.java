package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

public abstract class JtAbstractTreeListSelectionDialog<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IWorkbenchWindow window;

	private ElementTreeSelectionDialog dialog;

	private String message = "Selecione uma String (* = any string, ? = any char):";

	public JtAbstractTreeListSelectionDialog(IWorkbenchWindow window) {
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
	
	protected abstract ITreeContentProvider getContentProvider();

	public void open() {
		if (window != null) {
			init();
			this.dialog = new ElementTreeSelectionDialog(window.getShell(), getLabelProvider(), getContentProvider());
			this.dialog.setTitle(getTitle());
			this.dialog.setMessage(message);
			this.dialog.setInput(getList());
			this.dialog.open();
			finish();
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
}
