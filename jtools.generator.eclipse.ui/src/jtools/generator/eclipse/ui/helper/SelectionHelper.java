package jtools.generator.eclipse.ui.helper;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.IStructuredSelection;

public class SelectionHelper {

	public static boolean isJavaProject(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IJavaProject.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	public static boolean isFolder(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IFolder.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	public static boolean isCompilationUnit(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return ICompilationUnit.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

}
