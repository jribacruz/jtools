package jtools.eclipse.core.internal.function;

import jtools.eclipse.core.internal.model.base.JxDirImpl;
import jtools.eclipse.core.model.base.JxDir;
import jtools.eclipse.core.model.base.JxFile;

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
