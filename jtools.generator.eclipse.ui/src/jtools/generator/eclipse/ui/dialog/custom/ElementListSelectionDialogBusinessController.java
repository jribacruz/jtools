package jtools.generator.eclipse.ui.dialog.custom;

import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.MessageContext;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractElementListSelection;
import jtools.generator.eclipse.ui.dialog.providers.ModelLabelProvider;
import jtools.generator.eclipse.ui.helper.ModelHelper;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.Model;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class ElementListSelectionDialogBusinessController extends JtAbstractElementListSelection<Model> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementListSelectionDialogBusinessController(IWorkbenchWindow window) {
		super(window);
	}

	@Override
	protected Model[] getList() {
		IProject project = Context.getCurrentInstance().getSelectedProject();
		List<Model> models = ProjectHelper.getModels(project);
		log("%d models carregados para o projeto %s", models.size(), project.getName());
		List<Model> filteredModelList = ModelHelper.filterModels(models, new Predicate<Model>() {
			@Override
			public boolean apply(Model model) {
				boolean has = ModelHelper.hasAnnotationTypeName(model, "BusinessController");
				MessageContext.printlnConsole("Verificando se model %s possui annotation @BusinessController: [%b]", model.getName(), has);
				return has;
			}
		});
		log("%d business controllers carregadas para o projeto %s", filteredModelList.size(), project.getName());
		return ModelHelper.asArray(filteredModelList);
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new ModelLabelProvider();
	}
}
