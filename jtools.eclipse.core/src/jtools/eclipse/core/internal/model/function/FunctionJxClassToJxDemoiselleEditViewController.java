package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxDemoiselleEditViewControllerImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxDemoiselleEditViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxDemoiselleEditViewController implements Function<JxJavaClass, JxDemoiselleEditViewController> {

	@Override
	public JxDemoiselleEditViewController apply(JxJavaClass input) {
		try {
			return new JxDemoiselleEditViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
