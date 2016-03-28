package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxJavaClassImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxFileToJxClass implements Function<JxFile, JxJavaClass> {

	@Override
	public JxJavaClass apply(JxFile input) {
		try {
			return new JxJavaClassImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
