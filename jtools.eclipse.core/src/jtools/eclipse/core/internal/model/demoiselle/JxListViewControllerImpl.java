package jtools.eclipse.core.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.internal.model.JxBeanImpl;
import jtools.eclipse.core.model.demoiselle.JxListViewController;

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
