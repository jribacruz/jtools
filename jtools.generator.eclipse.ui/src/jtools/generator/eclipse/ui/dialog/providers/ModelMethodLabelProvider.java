package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.JtMethod;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelMethodLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		JtMethod method = (JtMethod) element;
		return method.getName();
	}

}
