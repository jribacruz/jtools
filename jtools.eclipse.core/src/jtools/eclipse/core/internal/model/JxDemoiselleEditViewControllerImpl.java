package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxDemoiselleEditViewController;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleEditViewControllerImpl extends JxBeanImpl implements JxDemoiselleEditViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxDemoiselleEditViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
