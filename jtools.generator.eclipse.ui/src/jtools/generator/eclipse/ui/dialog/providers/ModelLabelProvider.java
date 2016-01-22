package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.Model;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		Model model = (Model) element;
		return model.getName();
	}

}
