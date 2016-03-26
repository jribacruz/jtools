package jtools.commons.function;

import jtools.commons.internal.model.base.MDirImpl;
import jtools.commons.model.base.XDir;
import jtools.commons.model.base.XFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMDir implements Function<XFile, XDir> {

	@Override
	public XDir apply(XFile input) {
		return new MDirImpl(input.getFile());
	}

}
