package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxClassImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxFileToJxClass implements Function<JxFile, JxClass> {

	@Override
	public JxClass apply(JxFile input) {
		try {
			return new JxClassImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
