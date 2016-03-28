package jtools.eclipse.core.internal.function;

import jtools.eclipse.core.internal.model.JxPackageImpl;
import jtools.eclipse.core.model.JxPackage;
import jtools.eclipse.core.model.base.JxFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxFileToJxPackage implements Function<JxFile, JxPackage> {

	@Override
	public JxPackage apply(JxFile input) {
		return new JxPackageImpl(input.getFile());
	}

}
