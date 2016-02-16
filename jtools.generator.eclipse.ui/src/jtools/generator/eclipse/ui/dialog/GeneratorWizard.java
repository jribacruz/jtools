package jtools.generator.eclipse.ui.dialog;

import java.io.IOException;
import java.net.URISyntaxException;

import jtools.eclipse.core.console.JtConsole;
import jtools.eclipse.core.util.JtUI;
import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.MessageContext;
import jtools.generator.eclipse.ui.context.MessageContext.SeverityType;
import jtools.generator.eclipse.ui.core.JtGenerator;

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

	public GeneratorWizard() {
		super();
	}

	@Override
	public void addPages() {
		this.page1 = new GeneratorPropertiesPage("page1");
		addPage(page1);
	}

	@Override
	public boolean performFinish() {

		try {
			JtConsole.log("[GeneratorWizard] Iniciando criação do Jtool Project %s", page1.getProjectName());
			IProject project = createJTProject();
			JtConsole.log("[GeneratorWizard] Adicionando Java Nature");
			addJavaNature(project);
			JtConsole.log("[GeneratorWizard] Adicionando JRE");
			addDefaultJRE(project);
			JtConsole.log("[GeneratorWizard] Adicionando Plugin Nature");
			addPluginNature(project);
			JtConsole.log("[GeneratorWizard] Adicionando Plugin Dependencies");
			addPluginDependencies(project);
			JtConsole.log("[GeneratorWizard] Criando source folder");
			createSrcFolder(project);
			JtConsole.log("[GeneratorWizard] Criando META-INF folder");
			createMetaInfFolder(project);
			JtConsole.log("[GeneratorWizard] Criando template folder");
			createTemplatesFolder(project);
			createSrcPackage(project);

			JtConsole.log("[GeneratorWizard] Criando Plugin Activator");
			generateActivator(project);
			JtConsole.log("[GeneratorWizard] Criando MANIFEST.MF");
			generateManifestMf(project);

			JtUI.refreshProject(project);
			JtConsole.log("[GeneratorWizard] Projeto Jtool %s criado com sucesso.", page1.getProjectName());

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
		} catch (Exception e) {
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
		return JtUI.create(page1.getProjectName());
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addPluginNature(IProject project) throws CoreException {
		JtUI.addNature(project, "org.eclipse.pde.PluginNature");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void addJavaNature(IProject project) throws CoreException {
		JtUI.addNature(project, JavaCore.NATURE_ID);
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createSrcFolder(IProject project) throws CoreException {
		JtUI.createSourceFolder(project, "src");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createMetaInfFolder(IProject project) throws CoreException {
		JtUI.createFolder(project, "META-INF");
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	private void createTemplatesFolder(IProject project) throws CoreException {
		JtUI.createFolder(project, "templates");
	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	private void addDefaultJRE(IProject project) throws JavaModelException {
		JtUI.addDefaultJRE(project);

	}

	/**
	 * 
	 * @param project
	 * @throws JavaModelException
	 */
	private void addPluginDependencies(IProject project) throws JavaModelException {
		JtUI.addClasspathEntry(project, JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
	}

	public void generateManifestMf(IProject project) throws URISyntaxException, IOException, ParseException, CompileException,
			RenderException {
		//@formatter:off
		JtGenerator.load("MANIFEST.MF.twig")
				.put("projectName", project.getName())
			.write(project, "/META-INF/MANIFEST.MF");
		//@formatter:on
	}

	public void generateActivator(IProject project) throws URISyntaxException, IOException, ParseException, CompileException,
			RenderException {
		//@formatter:off
		JtGenerator.load("Activator.java.twig")
				.put("projectName", project.getName())
			.write(project, "/src/", srcPackageDir, "/Activator.java");
		//@formatter:on

	}

	public void createSrcPackage(IProject project) {
		this.srcPackageDir = project.getName().replace(".", "/");
		String path = project.getLocation().toString() + "/src/" + srcPackageDir;
		Context.getCurrentInstance().mkdirs(path);
	}
}
