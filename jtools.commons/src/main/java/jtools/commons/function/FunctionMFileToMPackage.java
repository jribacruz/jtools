package jtools.commons.function;

import jtools.commons.internal.model.MPackageImpl;
import jtools.commons.model.MPackage;
import jtools.commons.model.base.MFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMPackage implements Function<MFile, MPackage> {

	@Override
	public MPackage apply(MFile input) {
		return new MPackageImpl(input.getFile());
	}

}
