package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MListViewControllerImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.demoiselle.XListViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMClassToMListViewController implements Function<XClass, XListViewController> {

	@Override
	public XListViewController apply(XClass input) {
		try {
			return new MListViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
