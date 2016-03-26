package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MBusinessControllerImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.demoiselle.XBusinessController;

import com.google.common.base.Function;

public class FunctionMClassToMBusinessController implements Function<XClass, XBusinessController> {

	@Override
	public XBusinessController apply(XClass input) {
		try {
			return new MBusinessControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
