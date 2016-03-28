package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxPersistenceControllerImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxPersistenceController;

import com.google.common.base.Function;

public class FunctionJxClassToJxPersistenceController implements Function<JxClass, JxPersistenceController> {

	@Override
	public JxPersistenceController apply(JxClass input) {
		try {
			return new JxPersistenceControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
