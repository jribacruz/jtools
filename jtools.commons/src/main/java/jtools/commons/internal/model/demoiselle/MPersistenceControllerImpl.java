package jtools.commons.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MBeanImpl;
import jtools.commons.model.demoiselle.MPersistenceController;

public class MPersistenceControllerImpl extends MBeanImpl implements MPersistenceController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MPersistenceControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
