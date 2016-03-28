package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxDemoisellePersistenceController;

/**
 * @author jcruz
 *
 */
public class JxDemoisellePersistenceControllerImpl extends JxBeanImpl implements JxDemoisellePersistenceController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxDemoisellePersistenceControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
