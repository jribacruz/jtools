package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoiselleEditViewControllerImpl;
import jtools.eclipse.core.model.JxDemoiselleEditViewController;
import jtools.eclipse.core.model.JxJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxDemoiselleEditViewController implements Function<JxJavaClass, JxDemoiselleEditViewController> {

	@Override
	public JxDemoiselleEditViewController apply(JxJavaClass input) {
		return new JxDemoiselleEditViewControllerImpl(input.getJavaClass());
	}

}
