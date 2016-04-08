package jtools.action.shortcuts.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;



public class SampleNewWizard extends Wizard implements INewWizard {
	private SampleNewWizardPage page;
	private ISelection selection;


	public SampleNewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	

	public void addPages() {
		page = new SampleNewWizardPage(selection);
		addPage(page);
	}

	public boolean performFinish() {
		return true;
	}
	

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}