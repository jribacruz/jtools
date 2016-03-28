package jtools.eclipse.core.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.internal.model.JxBeanImpl;
import jtools.eclipse.core.model.demoiselle.JxBusinessController;

public class JxBusinessControllerImpl extends JxBeanImpl implements JxBusinessController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxBusinessControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
