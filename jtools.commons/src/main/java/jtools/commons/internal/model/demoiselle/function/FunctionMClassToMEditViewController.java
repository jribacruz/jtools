package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MEditViewControllerImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.demoiselle.XEditViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMClassToMEditViewController implements Function<XClass, XEditViewController> {

	@Override
	public XEditViewController apply(XClass input) {
		try {
			return new MEditViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
