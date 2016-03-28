package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxDemoiselleBusinessController;

public class JxDemoiselleBusinessControllerImpl extends JxBeanImpl implements JxDemoiselleBusinessController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxDemoiselleBusinessControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
