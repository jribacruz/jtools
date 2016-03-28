package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxDemoiselleListViewControllerImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxDemoiselleListViewController;

import com.google.common.base.Function;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxDemoiselleListViewController implements Function<JxJavaClass, JxDemoiselleListViewController> {

	@Override
	public JxDemoiselleListViewController apply(JxJavaClass input) {
		try {
			return new JxDemoiselleListViewControllerImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
