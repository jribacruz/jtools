package jtools.generator.eclipse.ui.handlers;

import java.io.File;

import jtools.generator.context.JTContext;
import jtools.generator.context.MessageContext;
import jtools.generator.eclipse.ui.Activator;
import jtools.generator.menu.JTAbstractHandler;

/**
 * 
 * @author jcruz
 *
 */
public class JTProjectEclipseHandler extends JTAbstractHandler {

	public void execute() {
		File file = JTContext.getCurrentInstance().load(Activator.PLUGIN_ID, "templates/AbstractHandler.vm");
		MessageContext.add("Arquivo Carregado", file.getName());
	}
}
