package jtools.eclipse.core.util;

import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.console.JtConsole;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.google.common.base.Predicate;

public class JtUI {

	public static Image getImage(String bundleId, String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, path).createImage();
	}

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
	 * Cria um projeto no workspace
	 * 
	 * @param name
	 *            Nome do projeto
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
			JtConsole.log(e.getMessage());
		}
		return units;
	}

	public static IPackageFragmentRoot[] getPackageFragmentRoots(IJavaProject javaProject) {
		List<IPackageFragmentRoot> roots = new ArrayList<>();
		try {
			IPackageFragmentRoot[] fragmentRoots = javaProject.getPackageFragmentRoots();
			for (int i = 0; i < fragmentRoots.length; i++) {
				IPackageFragmentRoot root = fragmentRoots[i];
				roots.add(root);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return roots.toArray(new IPackageFragmentRoot[] {});
	}

	public static IPackageFragmentRoot[] getPackageFragmentRoots(IJavaProject javaProject, Predicate<IPackageFragmentRoot> predicate) {
		List<IPackageFragmentRoot> roots = new ArrayList<>();
		try {
			IPackageFragmentRoot[] fragmentRoots = javaProject.getPackageFragmentRoots();
			for (int i = 0; i < fragmentRoots.length; i++) {
				IPackageFragmentRoot root = fragmentRoots[i];
				if (predicate.apply(root)) {
					roots.add(root);
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return roots.toArray(new IPackageFragmentRoot[] {});
	}

	public static IPackageFragmentRoot getSrcMainJava(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/main/java");
	}

	public static IPackageFragmentRoot getSrcTestJava(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/test/java");
	}

	public static IPackageFragmentRoot getSrcMainGroovy(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/test/groovy");
	}

	public static IPackageFragmentRoot getSrcMainResources(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/main/resources");
	}

	public static IPackageFragmentRoot getSrcTestResources(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/test/resources");
	}

	public static IPackageFragmentRoot getSrcSite(IJavaProject javaProject) {
		return javaProject.getPackageFragmentRoot("src/site");
	}

	public static boolean isPackageFragment(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IPackageFragment.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isJavaProject(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IJavaProject.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isFolder(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return IFolder.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

	/**
	 * 
	 * @param selection
	 * @return
	 */
	public static boolean isCompilationUnit(IStructuredSelection selection) {
		if (selection != null) {
			IAdaptable adaptable = (IAdaptable) selection.getFirstElement();
			return ICompilationUnit.class.isAssignableFrom(adaptable.getClass());
		}
		return false;
	}

}
