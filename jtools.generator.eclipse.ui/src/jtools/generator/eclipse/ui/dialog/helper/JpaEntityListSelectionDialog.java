package jtools.generator.eclipse.ui.dialog.helper;

import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.providers.ModelLabelProvider;
import jtools.generator.eclipse.ui.dialog.template.Dialog;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.Model;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.google.common.base.Predicate;

public class JpaEntityListSelectionDialog implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {

		IProject project = Context.getCurrentInstance().getSelectedProject();

		List<Model> units = ProjectHelper.getModels(project, new Predicate<Model>() {

			@Override
			public boolean apply(Model arg0) {
				return arg0.getName().equalsIgnoreCase("Test1");
			}
		});

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new ModelLabelProvider());
		dialog.setTitle("Selecione um projeto");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(units.toArray(new Model[] {}));
		dialog.open();

	}

}
