package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.Method;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelMethodLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		Method method = (Method) element;
		return method.getName();
	}

}
