package jtools.eclipse.core.facade;

import java.io.Serializable;

public class Jt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static JtSelectionHelper SELECTION = new JtSelectionHelper();

	public final static JtConsoleHelper CONSOLE = new JtConsoleHelper();

	public final static JtProjectHelper PROJECT = new JtProjectHelper();

	public final static JtDialogHelper DIALOG = new JtDialogHelper();

	public final static JtMessageHelper MESSAGE = new JtMessageHelper();

	public final static JtModelHelper MODEL = new JtModelHelper();

	public final static JtUtilHelper UTIL = new JtUtilHelper();

}
