package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxDemoiselleListViewController;

/**
 * 
 * @author jcruz
 *
 */
public class JxDemoiselleListViewControllerImpl extends JxBeanImpl implements JxDemoiselleListViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxDemoiselleListViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
