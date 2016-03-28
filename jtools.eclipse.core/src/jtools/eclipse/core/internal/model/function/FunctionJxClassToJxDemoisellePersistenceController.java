package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxDemoisellePersistenceControllerImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;

import com.google.common.base.Function;

public class FunctionJxClassToJxDemoisellePersistenceController implements Function<JxClass, JxDemoisellePersistenceController> {

	@Override
	public JxDemoisellePersistenceController apply(JxClass input) {
		try {
			return new JxDemoisellePersistenceControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
