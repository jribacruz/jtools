package jtools.generator.eclipse.ui.dialog.helper;

import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.dialog.providers.CompilationUnitLabelProvider;
import jtools.generator.eclipse.ui.dialog.template.Dialog;
import jtools.generator.eclipse.ui.helper.ProjectHelper;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class JpaEntityListSelectionDialog implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {
		
		IProject project = Context.getCurrentInstance().getSelectedProject();
		List<ICompilationUnit> units = ProjectHelper.getCompilationUnits(project);
		
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new CompilationUnitLabelProvider());
		dialog.setTitle("Selecione um projeto");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(units.toArray(new ICompilationUnit[]{}));
		dialog.open();

	}

}
