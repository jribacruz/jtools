package jtools.generator.eclipse.ui.dialog.providers;

import jtools.generator.eclipse.ui.model.JtModel;

import org.eclipse.jface.viewers.LabelProvider;

public class ModelLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		JtModel model = (JtModel) element;
		return model.getName();
	}

}
