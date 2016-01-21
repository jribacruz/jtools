package jtools.generator.eclipse.ui.dialog;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.MessageContext;
import jtools.generator.eclipse.ui.context.MessageContext.SeverityType;
import jtools.generator.eclipse.ui.helper.ProjectHelper;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.wizard.Wizard;

import com.lyncode.jtwig.exception.CompileException;
import com.lyncode.jtwig.exception.ParseException;
import com.lyncode.jtwig.exception.RenderException;

public class GeneratorWizard extends Wizard {

	private GeneratorPropertiesPage page1;

	private String srcPackageDir;

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
			createSrcPackage(project);

			generateActivator(project);
			generateManifestMf(project);

			ProjectHelper.refreshProject(project);

		} catch (CoreException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		} catch (URISyntaxException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		} catch (IOException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		} catch (ParseException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		} catch (CompileException e) {
			MessageContext.add("Aviso", SeverityType.ERROR, e.getMessage());
		} catch (RenderException e) {
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
		return ProjectHelper.create(page1.getProjectName());
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addPluginNature(IProject project) throws CoreException {
		ProjectHelper.addNature(project, "org.eclipse.pde.PluginNature");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addJavaNature(IProject project) throws CoreException {
		ProjectHelper.addNature(project, JavaCore.NATURE_ID);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createSrcFolder(IProject project) throws CoreException {
		ProjectHelper.createSourceFolder(project, "src");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createMetaInfFolder(IProject project) throws CoreException {
		ProjectHelper.createFolder(project, "META-INF");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createTemplatesFolder(IProject project) throws CoreException {
		ProjectHelper.createFolder(project, "templates");
	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	private void addDefaultJRE(IProject project) throws JavaModelException {
		ProjectHelper.addDefaultJRE(project);

	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	private void addPluginDependencies(IProject project) throws JavaModelException {
		ProjectHelper.addClasspathEntry(project, JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
	}

	public void generateManifestMf(IProject project) throws URISyntaxException, IOException, ParseException, CompileException,
			RenderException {
		String path = project.getLocation().toString();
		File template = Context.getCurrentInstance().load("jtools.generator.eclipse.ui", "templates/MANIFEST.MF.twig");

		Map<String, Object> map = new HashMap<>();
		map.put("projectName", project.getName());

		Context.getCurrentInstance().generate(template, path + "/META-INF/MANIFEST.MF", map);
	}

	public void generateActivator(IProject project) throws URISyntaxException, IOException, ParseException, CompileException,
			RenderException {
		String path = project.getLocation().toString();
		File template = Context.getCurrentInstance().load("jtools.generator.eclipse.ui", "templates/Activator.java.twig");

		Map<String, Object> map = new HashMap<>();
		map.put("projectName", project.getName());

		Context.getCurrentInstance().generate(template, path + "/src/" + srcPackageDir + "/Activator.java", map);
	}

	public void createSrcPackage(IProject project) {
		this.srcPackageDir = project.getName().replace(".", "/");
		String path = project.getLocation().toString() + "/src/" + srcPackageDir;
		Context.getCurrentInstance().mkdirs(path);
	}
}
