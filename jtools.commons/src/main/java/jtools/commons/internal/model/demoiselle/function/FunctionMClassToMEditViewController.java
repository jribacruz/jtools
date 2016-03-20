package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MEditViewControllerImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.demoiselle.MEditViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMClassToMEditViewController implements Function<MClass, MEditViewController> {

	@Override
	public MEditViewController apply(MClass input) {
		try {
			return new MEditViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
