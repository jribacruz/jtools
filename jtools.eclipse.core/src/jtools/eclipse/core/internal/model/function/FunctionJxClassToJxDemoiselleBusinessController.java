package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxDemoiselleBusinessControllerImpl;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxJavaClass;

import com.google.common.base.Function;

public class FunctionJxClassToJxDemoiselleBusinessController implements Function<JxJavaClass, JxDemoiselleBusinessController> {

	@Override
	public JxDemoiselleBusinessController apply(JxJavaClass input) {
		try {
			return new JxDemoiselleBusinessControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
