package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoiselleListViewControllerImpl;
import jtools.eclipse.core.model.JxDemoiselleListViewController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJavaClass;

/**
 * 
 * @author jcruz
 *
 */
public class FunctionJxClassToJxDemoiselleListViewController implements Function<JxJavaClass, JxDemoiselleListViewController> {

	private JxDemoiselleProject demoiselleProject;

	public FunctionJxClassToJxDemoiselleListViewController(JxDemoiselleProject demoiselleProject) {
		super();
		this.demoiselleProject = demoiselleProject;
	}

	@Override
	public JxDemoiselleListViewController apply(JxJavaClass input) {
		return new JxDemoiselleListViewControllerImpl(demoiselleProject, input.getJavaClass());
	}

}
