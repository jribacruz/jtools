package jtools.commons.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MBeanImpl;
import jtools.commons.model.demoiselle.XEditViewController;

/**
 * 
 * @author jcruz
 *
 */
public class MEditViewControllerImpl extends MBeanImpl implements XEditViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MEditViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
