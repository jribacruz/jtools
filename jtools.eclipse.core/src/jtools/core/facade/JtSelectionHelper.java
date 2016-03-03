package jtools.core.facade;

import java.io.Serializable;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.viewers.IStructuredSelection;

public class JtSelectionHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static boolean isPackageFragment(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IPackageFragment.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isJavaProject(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IJavaProject.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isFolder(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IFolder.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isCompilationUnit(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return ICompilationUnit.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}
}
