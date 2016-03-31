package jtools.eclipse.core.service;

import java.io.Serializable;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

/**
 * 
 * @author jcruz
 *
 */
public class ConsoleService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MessageConsole messageConsole;

	public void log(String message, Object... params) {
		if (messageConsole == null) {
			ConsolePlugin consolePlugin = ConsolePlugin.getDefault();
			IConsoleManager consoleManager = consolePlugin.getConsoleManager();
			messageConsole = new MessageConsole("Jtools Console", null);
			consoleManager.addConsoles(new IConsole[] { messageConsole });
		}
		messageConsole.newMessageStream().println(String.format(message, params));
	}
}
