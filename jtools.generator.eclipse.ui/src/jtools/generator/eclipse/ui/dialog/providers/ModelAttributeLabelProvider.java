package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.Attribute;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelAttributeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		Attribute attribute = (Attribute) element;
		return attribute.getName();
	}

}
