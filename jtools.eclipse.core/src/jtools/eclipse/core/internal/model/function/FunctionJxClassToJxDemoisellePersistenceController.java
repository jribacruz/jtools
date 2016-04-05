package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoisellePersistenceControllerImpl;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxJavaClass;

public class FunctionJxClassToJxDemoisellePersistenceController implements Function<JxJavaClass, JxDemoisellePersistenceController> {

	@Override
	public JxDemoisellePersistenceController apply(JxJavaClass input) {
		return new JxDemoisellePersistenceControllerImpl(input.getJavaClass());
	}

}
