package jtools.eclipse.core.internal.model.function;

import jtools.eclipse.core.internal.model.JxDirImpl;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxFileToJxDir implements Function<JxFile, JxDir> {

	@Override
	public JxDir apply(JxFile input) {
		return new JxDirImpl(input.getFile());
	}

}
