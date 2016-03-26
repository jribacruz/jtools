package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MPersistenceControllerImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.demoiselle.XPersistenceController;

import com.google.common.base.Function;

public class FunctionMClassToMPersistenceController implements Function<XClass, XPersistenceController> {

	@Override
	public XPersistenceController apply(XClass input) {
		try {
			return new MPersistenceControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
