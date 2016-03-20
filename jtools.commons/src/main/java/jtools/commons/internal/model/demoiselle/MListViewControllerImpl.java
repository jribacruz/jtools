package jtools.commons.internal.model.demoiselle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.MBeanImpl;
import jtools.commons.model.demoiselle.MListViewController;

/**
 * 
 * @author jcruz
 *
 */
public class MListViewControllerImpl extends MBeanImpl implements MListViewController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MListViewControllerImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

}
