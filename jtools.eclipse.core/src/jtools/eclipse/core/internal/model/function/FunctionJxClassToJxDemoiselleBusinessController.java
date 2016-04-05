package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoiselleBusinessControllerImpl;
import jtools.eclipse.core.model.JxDemoiselleBusinessController;
import jtools.eclipse.core.model.JxJavaClass;

public class FunctionJxClassToJxDemoiselleBusinessController implements Function<JxJavaClass, JxDemoiselleBusinessController> {

	@Override
	public JxDemoiselleBusinessController apply(JxJavaClass input) {
		return new JxDemoiselleBusinessControllerImpl(input.getJavaClass());
	}

}
