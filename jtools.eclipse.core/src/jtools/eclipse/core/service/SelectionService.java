package jtools.eclipse.core.service;

import jtools.eclipse.core.Activator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.IStructuredSelection;

public class SelectionService {

	public static IProject getProjectFromSelection() {
		IStructuredSelection selection = (IStructuredSelection) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().getSelection();
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();

			// File
			if (adaptable instanceof IFile) {
				return ((IResource) adaptable).getProject();
			}

			// CompilationUnit
			if (adaptable instanceof ICompilationUnit) {
				return ((IJavaElement) adaptable).getJavaProject().getProject();
			}

			// Folder
			if (adaptable instanceof IFolder) {
				return ((IResource) adaptable).getProject();
			}

			if (adaptable instanceof IPackageFragment) {
				return ((IJavaElement) adaptable).getJavaProject().getProject();
			}

			if (adaptable instanceof IPackageFragmentRoot) {
				return ((IJavaElement) adaptable).getJavaProject().getProject();
			}

			if (adaptable instanceof IJavaProject) {
				return ((IJavaProject) adaptable).getJavaProject().getProject();
			}

			if (adaptable instanceof IProject) {
				return (IProject) adaptable;
			}

		}
		return null;
	}
}
