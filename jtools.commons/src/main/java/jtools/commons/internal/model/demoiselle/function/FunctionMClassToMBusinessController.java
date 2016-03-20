package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MBusinessControllerImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.demoiselle.MBusinessController;

import com.google.common.base.Function;

public class FunctionMClassToMBusinessController implements Function<MClass, MBusinessController> {

	@Override
	public MBusinessController apply(MClass input) {
		try {
			return new MBusinessControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
