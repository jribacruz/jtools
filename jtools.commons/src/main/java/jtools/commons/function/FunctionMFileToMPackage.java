package jtools.commons.function;

import jtools.commons.internal.model.MPackageImpl;
import jtools.commons.model.XPackage;
import jtools.commons.model.base.XFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMPackage implements Function<XFile, XPackage> {

	@Override
	public XPackage apply(XFile input) {
		return new MPackageImpl(input.getFile());
	}

}
