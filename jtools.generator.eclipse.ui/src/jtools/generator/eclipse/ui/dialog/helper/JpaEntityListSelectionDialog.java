package jtools.generator.eclipse.ui.dialog.helper;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.template.Dialog;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.IWorkbenchWindow;

public class JpaEntityListSelectionDialog implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {
		IProject project = Context.getCurrentInstance().getSelectedProject();
	}

}
