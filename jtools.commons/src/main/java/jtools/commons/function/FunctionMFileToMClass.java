package jtools.commons.function;

import java.io.IOException;

import jtools.commons.internal.model.MClassImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.base.MFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMClass implements Function<MFile, MClass> {

	@Override
	public MClass apply(MFile input) {
		try {
			return new MClassImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
