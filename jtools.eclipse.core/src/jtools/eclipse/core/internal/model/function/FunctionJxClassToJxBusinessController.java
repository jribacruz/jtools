package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxBusinessControllerImpl;
import jtools.eclipse.core.model.JxBusinessController;
import jtools.eclipse.core.model.JxClass;

import com.google.common.base.Function;

public class FunctionJxClassToJxBusinessController implements Function<JxClass, JxBusinessController> {

	@Override
	public JxBusinessController apply(JxClass input) {
		try {
			return new JxBusinessControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
