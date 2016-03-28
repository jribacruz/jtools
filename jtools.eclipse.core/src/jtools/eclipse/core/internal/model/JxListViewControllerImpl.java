package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxListViewController;

/**
 * 
 * @author jcruz
 *
 */
public class JxListViewControllerImpl extends JxBeanImpl implements JxListViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxListViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
