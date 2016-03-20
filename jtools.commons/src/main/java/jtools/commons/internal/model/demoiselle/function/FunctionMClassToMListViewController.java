package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.demoiselle.MListViewControllerImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.demoiselle.MListViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionMClassToMListViewController implements Function<MClass, MListViewController> {

	@Override
	public MListViewController apply(MClass input) {
		try {
			return new MListViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
