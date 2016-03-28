package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxEditViewControllerImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxEditViewController;

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
