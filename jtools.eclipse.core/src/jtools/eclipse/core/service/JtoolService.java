package jtools.eclipse.core.service;

import java.io.File;
import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

import jtools.eclipse.core.Activator;

/**
 * 
 * @author jcruz
 *
 */
public class JtoolService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MessageConsole messageConsole;

	/**
	 * 
	 * Imprime uma mensagem no console do eclipse.
	 * 
	 * @param message
	 * @param params
	 */
	public static void printConsole(String message, Object... params) {
		if (messageConsole == null) {
			ConsolePlugin consolePlugin = ConsolePlugin.getDefault();
			IConsoleManager consoleManager = consolePlugin.getConsoleManager();
			messageConsole = new MessageConsole("Jtools Console", null);
			consoleManager.addConsoles(new IConsole[] { messageConsole });
		}
		messageConsole.newMessageStream().println(String.format(message, params));
	}

	/**
	 * 
	 * Verifica se a seleção corrente é um arquivo.
	 * 
	 * @return
	 */
	public static boolean isFileSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IFile;
	}

	/**
	 * 
	 * Verifica se a seleção atual é um arquivo.
	 * 
	 * @return
	 */
	public static boolean isFolderSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IFolder;
	}

	/**
	 * 
	 * Verifica se a seleção atual é um arquivo java.
	 * 
	 * @return
	 */
	public static boolean isCompilationUnitSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof ICompilationUnit;
	}

	/**
	 * 
	 * Verifica se a seleção atual é um pacote java.
	 * 
	 * @return
	 */
	public static boolean isPackageFragmentSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IPackageFragment;
	}

	/**
	 * 
	 * Verifica se a seleção atual é um source folder.
	 * 
	 * @return
	 */
	public static boolean isPackageFragmentRootSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IPackageFragmentRoot;
	}

	/**
	 * 
	 * Verifica se a seleção atual é um projeto java.
	 * 
	 * @return
	 */
	public static boolean isJavaProjectSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IJavaProject;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isProjectSelected() {
		IStructuredSelection selection = JtoolService.getCurrentSelection();
		IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
		return selection != null && adaptable instanceof IProject;
	}

	/**
	 * 
	 * Retorna a seleção atual.
	 * 
	 * @return
	 */
	public static IStructuredSelection getCurrentSelection() {
		return (IStructuredSelection) Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isMavenProject(IProject project) {
		return new File(String.format("%s/%s", FilenameUtils.normalizeNoEndSeparator(project.getFullPath().toString()), "pom.xml"))
				.exists();
	}

}
