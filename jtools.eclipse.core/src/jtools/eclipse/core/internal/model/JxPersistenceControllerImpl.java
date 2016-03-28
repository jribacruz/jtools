package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxPersistenceController;

/**
 * @author jcruz
 *
 */
public class JxPersistenceControllerImpl extends JxBeanImpl implements JxPersistenceController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxPersistenceControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
