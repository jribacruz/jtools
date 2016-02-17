package jtools.eclipse.core.facade;

import java.io.Serializable;

public class Jt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public final static JtSelection SELECTION = new JtSelection();

	public final static JtConsole CONSOLE = new JtConsole();

	public final static JtProject PROJECT = new JtProject();

	public final static JtDialog DIALOG = new JtDialog();

	public final static JtMessage MESSAGE = new JtMessage();

	public final static JtUtil UTIL = new JtUtil();

}
