package jtools.eclipse.core.provider;

import jtools.eclipse.core.facade.Jt;
import jtools.eclipse.core.model.JtAttribute;
import jtools.eclipse.core.model.JtMethod;
import jtools.eclipse.core.model.JtModel;

import org.eclipse.jface.viewers.LabelProvider;

public class JtModelLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof JtModel) {
			JtModel model = (JtModel) element;
			return model.getFullyQualifiedName();
		} else if (element instanceof JtMethod) {
			JtMethod method = (JtMethod) element;
			return Jt.MODEL.getMethodNameWithParams(method);
		} else if (element instanceof JtAttribute) {
			JtAttribute attribute = (JtAttribute) element;
			return attribute.getName();
		}
		return "";
	}
}
