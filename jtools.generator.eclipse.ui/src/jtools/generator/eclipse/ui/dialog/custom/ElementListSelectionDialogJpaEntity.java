package jtools.generator.eclipse.ui.dialog.custom;

import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.MessageContext;
import jtools.generator.eclipse.ui.dialog.providers.ModelLabelProvider;
import jtools.generator.eclipse.ui.dialog.template.Dialog;
import jtools.generator.eclipse.ui.helper.ModelHelper;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.Model;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.google.common.base.Predicate;

public class ElementListSelectionDialogJpaEntity implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {

		IProject project = Context.getCurrentInstance().getSelectedProject();

		List<Model> models = ProjectHelper.getModels(project);
		
		MessageContext.printlnConsole("%d models carregados para o projeto %s", models.size(), project.getName());
		
		List<Model> jpaEntityModels = getJpaEntityModels(models);

		MessageContext.printlnConsole("%d entidades JPA carregadas para o projeto %s", jpaEntityModels.size(), project.getName());

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new ModelLabelProvider());
		dialog.setTitle("Selecione uma entidade JPA");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(ModelHelper.asArray(jpaEntityModels));
		dialog.open();

	}

	/**
	 * Filtra os models com apenas aqueles que possuirem a annotation @Entity
	 * 
	 * @param models
	 * @return
	 */
	private List<Model> getJpaEntityModels(List<Model> models) {
		return ModelHelper.filterModels(models, new Predicate<Model>() {
			@Override
			public boolean apply(Model model) {
				return ModelHelper.hasAnnotationTypeName(model, "Entity");
			}
		});
	}
}
