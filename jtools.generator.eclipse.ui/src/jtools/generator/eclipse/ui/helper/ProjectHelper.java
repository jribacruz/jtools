package jtools.generator.eclipse.ui.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.context.MessageContext;
import jtools.generator.eclipse.ui.impl.ModelImpl;
import jtools.generator.eclipse.ui.model.Model;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * 
 * @author jcruz
 *
 */
public class ProjectHelper {

	/**
	 * 
	 * @param project
	 */
	public static void refreshProject(IProject project) {
		if (project != null) {
			try {
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param name
	 * @return
	 * @throws CoreException
	 */
	public static IProject create(String name) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);
		project.create(null);
		project.open(null);
		return project;
	}

	/**
	 * 
	 * @param project
	 * @param natureId
	 * @throws CoreException
	 */
	public static void addNature(IProject project, String natureId) throws CoreException {
		IProjectDescription desc = project.getDescription();
		String[] prevNatures = desc.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = natureId;
		desc.setNatureIds(newNatures);
		project.setDescription(desc, null);
	}

	/**
	 * 
	 * @param project
	 * @param name
	 * @throws CoreException
	 */
	public static void createSourceFolder(IProject project, String name) throws CoreException {
		IFolder sourceFolder = project.getFolder(name);
		sourceFolder.create(false, true, null);

		IJavaProject javaProject = JavaCore.create(project);
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
		addClasspathEntry(project, JavaCore.newSourceEntry(root.getPath()));
	}

	/**
	 * 
	 * @param project
	 * @param name
	 * @throws CoreException
	 */
	public static void createFolder(IProject project, String name) throws CoreException {
		IFolder folder = project.getFolder(name);
		folder.create(false, true, null);
	}

	/**
	 * 
	 * @param project
	 * @param classpathEntry
	 * @throws JavaModelException
	 */
	public static void addClasspathEntry(IProject project, IClasspathEntry classpathEntry) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = classpathEntry;
		javaProject.setRawClasspath(newEntries, null);
	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	public static void addDefaultJRE(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		javaProject.setRawClasspath(new IClasspathEntry[0], null);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaRuntime.getDefaultJREContainerEntry();
		javaProject.setRawClasspath(newEntries, null);
	}

	/**
	 * 
	 * @param project
	 * @return
	 * @throws JavaModelException
	 */
	public static List<ICompilationUnit> getCompilationUnits(IProject project) {
		IJavaProject javaProject = JavaCore.create(project);
		List<ICompilationUnit> units = new ArrayList<>();

		IPackageFragment[] packageFragments;
		try {
			packageFragments = javaProject.getPackageFragments();
			for (int i = 0; i < packageFragments.length; i++) {
				IPackageFragment packageFragment = packageFragments[i];
				ICompilationUnit[] compilationUnits = packageFragment.getCompilationUnits();
				for (ICompilationUnit compilationUnit : compilationUnits) {
					units.add(compilationUnit);
				}
			}
		} catch (JavaModelException e) {
			MessageContext.printlnConsole(e.getMessage());
		}

		return units;
	}

	public static List<Model> getModels(IProject project) {
		List<Model> models = new ArrayList<>();
		for (ICompilationUnit compilationUnit : getCompilationUnits(project)) {
			try {
				models.add(new ModelImpl(compilationUnit));
			} catch (FileNotFoundException e) {
				MessageContext.printlnConsole(e.getMessage());
			} catch (IOException e) {
				MessageContext.printlnConsole(e.getMessage());
			}
		}
		return models;
	}

}
