package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoiselleListViewControllerImpl;
import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxDemoiselleListViewController implements Function<JxJavaClass, JxDemoiselleListViewController> {

	@Override
	public JxDemoiselleListViewController apply(JxJavaClass input) {
		return new JxDemoiselleListViewControllerImpl(input.getJavaClass());
	}

}
