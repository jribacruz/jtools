package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MPersistenceControllerImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.demoiselle.MPersistenceController;

import com.google.common.base.Function;

public class FunctionMPersistenceController implements Function<MClass, MPersistenceController> {

	@Override
	public MPersistenceController apply(MClass input) {
		try {
			return new MPersistenceControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
