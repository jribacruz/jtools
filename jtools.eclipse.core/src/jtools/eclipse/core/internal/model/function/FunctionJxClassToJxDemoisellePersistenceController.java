package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxDemoisellePersistenceControllerImpl;
import jtools.eclipse.core.model.JxDemoisellePersistenceController;
import jtools.eclipse.core.model.JxDemoiselleProject;
import jtools.eclipse.core.model.JxJavaClass;

public class FunctionJxClassToJxDemoisellePersistenceController implements Function<JxJavaClass, JxDemoisellePersistenceController> {

	private JxDemoiselleProject demoiselleProject;

	public FunctionJxClassToJxDemoisellePersistenceController(JxDemoiselleProject demoiselleProject) {
		super();
		this.demoiselleProject = demoiselleProject;
	}

	@Override
	public JxDemoisellePersistenceController apply(JxJavaClass input) {
		return new JxDemoisellePersistenceControllerImpl(demoiselleProject, input.getJavaClass());
	}

}
