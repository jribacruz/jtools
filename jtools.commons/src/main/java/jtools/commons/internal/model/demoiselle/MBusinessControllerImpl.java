package jtools.commons.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MBeanImpl;
import jtools.commons.model.demoiselle.XBusinessController;

public class MBusinessControllerImpl extends MBeanImpl implements XBusinessController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBusinessControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
