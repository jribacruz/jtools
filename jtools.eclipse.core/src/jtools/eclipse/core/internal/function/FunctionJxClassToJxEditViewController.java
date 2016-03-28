package jtools.eclipse.core.internal.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.demoiselle.JxEditViewControllerImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.demoiselle.JxEditViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxEditViewController implements Function<JxClass, JxEditViewController> {

	@Override
	public JxEditViewController apply(JxClass input) {
		try {
			return new JxEditViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
