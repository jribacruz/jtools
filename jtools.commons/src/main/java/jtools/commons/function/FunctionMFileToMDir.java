package jtools.commons.function;

import jtools.commons.internal.model.base.MDirImpl;
import jtools.commons.model.base.MDir;
import jtools.commons.model.base.MFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMDir implements Function<MFile, MDir> {

	@Override
	public MDir apply(MFile input) {
		return new MDirImpl(input.getFile());
	}

}
