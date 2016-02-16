package jtools.generator.eclipse.ui.dialog.providers.content;

import jtools.eclipse.core.model.JtMethod;
import jtools.eclipse.core.model.JtModel;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class JtModelMethodTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {

	}

	@Override
	public Object[] getChildren(Object arg0) {
		if (arg0 instanceof JtModel) {
			JtModel model = (JtModel) arg0;
			return model.getMethods().toArray(new JtMethod[] {});
		}
		return new Object[] {};
	}

	@Override
	public Object[] getElements(Object arg0) {
		return (JtModel[]) arg0;
	}

	@Override
	public Object getParent(Object arg0) {
		if (arg0 instanceof JtMethod) {
			JtMethod method = (JtMethod) arg0;
			return (JtModel) method.getParentModel();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		return getChildren(arg0).length > 0;
	}

}
