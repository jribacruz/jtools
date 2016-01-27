package jtools.generator.eclipse.ui.dialog.helper;

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

public class PersistenceControllerListSelectionDialog implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {

		IProject project = Context.getCurrentInstance().getSelectedProject();

		List<Model> models = ProjectHelper.getModels(project);

		MessageContext.printlnConsole("%d models carregados para o projeto %s", models.size(), project.getName());

		List<Model> persistenceControllerModels = getPersistenceControllerModels(models);

		MessageContext.printlnConsole("%d persistence controllers carregadas para o projeto %s", persistenceControllerModels.size(),
				project.getName());

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new ModelLabelProvider());
		dialog.setTitle("Selecione um Persistence Controller");
		dialog.setMessage("Select a String (* = any string, ? = any char):");
		dialog.setElements(ModelHelper.asArray(persistenceControllerModels));
		dialog.open();

	}

	/**
	 * Filtra os models com apenas aqueles que possuirem a annotation @Entity
	 * 
	 * @param models
	 * @return
	 */
	private List<Model> getPersistenceControllerModels(List<Model> models) {
		return ModelHelper.filterModels(models, new Predicate<Model>() {
			@Override
			public boolean apply(Model model) {
				boolean has = ModelHelper.hasAnnotationTypeName(model, "PersistenceController");
				MessageContext.printlnConsole("Verificando se model %s possui annotation @PersistenceController: [%b]", model.getName(), has);
				return has;
			}
		});
	}
}
