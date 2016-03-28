package jtools.eclipse.core.internal.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.demoiselle.JxListViewControllerImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.demoiselle.JxListViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxListViewController implements Function<JxClass, JxListViewController> {

	@Override
	public JxListViewController apply(JxClass input) {
		try {
			return new JxListViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
