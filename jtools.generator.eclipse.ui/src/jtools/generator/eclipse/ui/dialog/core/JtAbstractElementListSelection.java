package jtools.generator.eclipse.ui.dialog.core;

import java.io.Serializable;

import jtools.generator.eclipse.ui.context.MessageContext;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public abstract class JtAbstractElementListSelection<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IWorkbenchWindow window;

	private LabelProvider labelProvider;

	private String title;

	private String message = "Selecione uma String (* = any string, ? = any char):";

	public JtAbstractElementListSelection(IWorkbenchWindow window) {
		super();
		this.window = window;
	}

	protected abstract T[] getList();

	protected abstract LabelProvider getLabelProvider();

	/**
	 * 
	 * @param message
	 * @param params
	 */
	protected void log(String message, Object... params) {
		MessageContext.printlnConsole(message, params);
	}

	/**
	 * 
	 * @param message
	 */
	protected void log(String message) {
		MessageContext.printlnConsole(message);
	}

	public void open() {
		if (window != null) {
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), getLabelProvider());
			dialog.setTitle(title);
			dialog.setMessage(message);
			dialog.setElements(getList());
			dialog.open();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
