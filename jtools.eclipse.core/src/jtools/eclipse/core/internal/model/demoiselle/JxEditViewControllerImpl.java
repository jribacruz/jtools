package jtools.eclipse.core.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.internal.model.JxBeanImpl;
import jtools.eclipse.core.model.demoiselle.JxEditViewController;

/**
 * 
 * @author jcruz
 *
 */
public class JxEditViewControllerImpl extends JxBeanImpl implements JxEditViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxEditViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
