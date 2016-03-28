package jtools.eclipse.core.internal.model.function;

import jtools.eclipse.core.internal.model.JxJavaPackageImpl;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxJavaPackage;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxFileToJxPackage implements Function<JxFile, JxJavaPackage> {

	@Override
	public JxJavaPackage apply(JxFile input) {
		return new JxJavaPackageImpl(input.getFile());
	}

}
