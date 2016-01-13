package jtools.generator.context;

import org.eclipse.jface.dialogs.MessageDialog;

public class MessageContext {

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

	public static void add(String title, String message) {
		MessageDialog.openInformation(null, title, message);
	}

	public static void add(String title, SeverityType severity, String message) {
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
