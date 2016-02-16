package jtools.java.project.viewer.provider;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ProjectTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

	@Override
	public Object[] getChildren(Object arg0) {
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
