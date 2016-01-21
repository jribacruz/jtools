package jtools.generator.eclipse.ui.context;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

/**
 * Contexto de mensagens padrão do Jtools.
 * 
 * @author jcruz
 *
 */
public class MessageContext {

	private static MessageConsole messageConsole;;

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

	public static void printlnConsole(String message, Object... params) {
		if (messageConsole == null) {
			ConsolePlugin consolePlugin = ConsolePlugin.getDefault();
			IConsoleManager consoleManager = consolePlugin.getConsoleManager();
			messageConsole = new MessageConsole("Jtools Console", null);
			consoleManager.addConsoles(new IConsole[] { messageConsole });
		}
		messageConsole.newMessageStream().println(String.format(message, params));
	}
}
