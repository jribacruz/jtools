package jtools.generator.eclipse.ui.dialog.custom;

import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.JtConsole;
import jtools.generator.eclipse.ui.dialog.providers.JtModelLabelProvider;
import jtools.generator.eclipse.ui.dialog.template.Dialog;
import jtools.generator.eclipse.ui.helper.ModelHelper;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.JtModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.google.common.base.Predicate;

public class ElementListSelectionDialogPersistenceController implements Dialog {

	@Override
	public void open(IWorkbenchWindow window) {

		IProject project = Context.getCurrentInstance().getSelectedProject();

		List<JtModel> models = ProjectHelper.getModels(project);

		JtConsole.log("%d models carregados para o projeto %s", models.size(), project.getName());

		List<JtModel> persistenceControllerModels = getPersistenceControllerModels(models);

		JtConsole.log("%d persistence controllers carregadas para o projeto %s", persistenceControllerModels.size(), project.getName());

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(window.getShell(), new JtModelLabelProvider());
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
	private List<JtModel> getPersistenceControllerModels(List<JtModel> models) {
		return ModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				boolean has = ModelHelper.hasAnnotationTypeName(model, "PersistenceController");
				JtConsole.log("Verificando se model %s possui annotation @PersistenceController: [%b]", model.getName(), has);
				return has;
			}
		});
	}
}
