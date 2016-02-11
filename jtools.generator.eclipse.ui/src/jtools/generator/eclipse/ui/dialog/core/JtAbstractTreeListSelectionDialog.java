package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;

import jtools.generator.eclipse.ui.dialog.event.FinishListener;

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

	private FinishListener finishListener;

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
}
