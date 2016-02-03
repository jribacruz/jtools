package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;

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
