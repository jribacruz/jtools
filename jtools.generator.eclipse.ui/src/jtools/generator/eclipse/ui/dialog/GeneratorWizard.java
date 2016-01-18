package jtools.generator.eclipse.ui.dialog;

import jtools.generator.context.MessageContext;
import jtools.generator.context.MessageContext.SeverityType;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.wizard.Wizard;

public class GeneratorWizard extends Wizard {

	private GeneratorPropertiesPage page1;

	@Override
	public void addPages() {
		this.page1 = new GeneratorPropertiesPage("page1");
		addPage(page1);
	}

	@Override
	public boolean performFinish() {

		try {
			IProject project = createJTProject();
			addJavaNature(project);
			addDefaultJRE(project);
			addPluginNature(project);
			addPluginDependencies(project);
			createSrcFolder(project);
			createMetaInfFolder(project);
			createTemplatesFolder(project);
		} catch (CoreException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		}
		return true;
	}

	/**
	 * 
	 * @return
	 * @throws CoreException
	 */
	private IProject createJTProject() throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(page1.getProjectName());
		project.create(null);
		project.open(null);
		return project;
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addPluginNature(IProject project) throws CoreException {
		IProjectDescription desc = project.getDescription();
		String[] prevNatures = desc.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = "org.eclipse.pde.PluginNature";
		desc.setNatureIds(newNatures);
		project.setDescription(desc, null);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addJavaNature(IProject project) throws CoreException {
		IProjectDescription desc = project.getDescription();
		String[] prevNatures = desc.getNatureIds();
		String[] newNatures = new String[prevNatures.length + 1];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		newNatures[prevNatures.length] = JavaCore.NATURE_ID;
		desc.setNatureIds(newNatures);
		project.setDescription(desc, null);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createSrcFolder(IProject project) throws CoreException {
		IFolder sourceFolder = project.getFolder("src");
		sourceFolder.create(false, true, null);

		IJavaProject javaProject = JavaCore.create(project);
		IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
		javaProject.setRawClasspath(newEntries, null);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createMetaInfFolder(IProject project) throws CoreException {
		IFolder folder = project.getFolder("META-INF");
		folder.create(false, true, null);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createTemplatesFolder(IProject project) throws CoreException {
		IFolder folder = project.getFolder("templates");
		folder.create(false, true, null);
	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	private void addDefaultJRE(IProject project) throws JavaModelException {
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
	 * @throws JavaModelException
	 */
	private void addPluginDependencies(IProject project) throws JavaModelException {
		IJavaProject javaProject = JavaCore.create(project);
		// javaProject.setRawClasspath(new IClasspathEntry[0], null);
		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
		newEntries[oldEntries.length] = JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins"));
		javaProject.setRawClasspath(newEntries, null);
	}

}
