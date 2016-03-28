package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxBusinessController;

public class JxBusinessControllerImpl extends JxBeanImpl implements JxBusinessController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxBusinessControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
