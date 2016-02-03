package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.JtAttribute;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelAttributeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		JtAttribute attribute = (JtAttribute) element;
		return attribute.getName();
	}

}
