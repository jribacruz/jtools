package jtools.eclipse.core.facade;

import java.io.Serializable;

import org.eclipse.jface.dialogs.MessageDialog;

public class JtMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Severidade da mensagem.
	 * 
	 * @author jcruz
	 *
	 */
	public enum SeverityType {
		/**
		 * Information (less critical)
		 */
		INFO,

		/**
		 * Warning
		 */
		WARN,

		/**
		 * Error
		 */
		ERROR
	}

	public void add(String title, String message) {
		MessageDialog.openInformation(null, title, message);
	}

	public void error(String message) {
		MessageDialog.openError(null, "Aviso", message);
	}

	public void add(String title, SeverityType severity, String message) {
		switch (severity) {
		case INFO:
			MessageDialog.openInformation(null, title, message);
			break;
		case ERROR:
			MessageDialog.openError(null, title, message);
			break;
		case WARN:
			MessageDialog.openWarning(null, title, message);
			break;
		}
	}

}
