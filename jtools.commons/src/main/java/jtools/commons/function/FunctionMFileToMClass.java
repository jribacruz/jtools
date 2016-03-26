package jtools.commons.function;

import java.io.IOException;

import jtools.commons.internal.model.MClassImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.base.XFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMFileToMClass implements Function<XFile, XClass> {

	@Override
	public XClass apply(XFile input) {
		try {
			return new MClassImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
