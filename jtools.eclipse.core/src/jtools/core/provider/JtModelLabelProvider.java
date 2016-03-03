package jtools.core.provider;

import jtools.core.facade.Jt;
import jtools.core.model.JtAttribute;
import jtools.core.model.JtMethod;
import jtools.core.model.JtModel;

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
