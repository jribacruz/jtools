package jtools.java.project.viewer.provider;

import jtools.eclipse.core.util.JtUI;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class JavaProjectTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

	@Override
	public Object[] getChildren(Object arg0) {
		if (arg0 instanceof IJavaProject) {
			IJavaProject javaProject = (IJavaProject) arg0;
			IPackageFragmentRoot[] roots = { JtUI.getPackageFragmentRootSrcMainJava(javaProject) };
			return roots;
		}
		return new Object[] {};
	}

	@Override
	public Object[] getElements(Object arg0) {
		return (IJavaProject[]) arg0;
	}

	@Override
	public Object getParent(Object arg0) {
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		return getChildren(arg0).length > 0;
	}

}
