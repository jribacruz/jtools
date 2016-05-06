package jtools.eclipse.core.generator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;

public class GeneratorTask<T extends GeneratorModel> extends Job {

	public GeneratorTask(String name) {
		super(name);
	}

	@Override
	protected IStatus run(IProgressMonitor arg0) {
		return null;
	}

}
