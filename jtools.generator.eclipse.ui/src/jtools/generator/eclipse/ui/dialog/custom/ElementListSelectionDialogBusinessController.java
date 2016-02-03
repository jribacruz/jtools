package jtools.generator.eclipse.ui.dialog.custom;

import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.JtConsole;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractElementListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.ModelLabelProvider;
import jtools.generator.eclipse.ui.helper.ModelHelper;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.JtModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class ElementListSelectionDialogBusinessController extends JtAbstractElementListSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	public ElementListSelectionDialogBusinessController(IWorkbenchWindow window) {
		super(window);
	}

	/**
	 * 
	 */
	@Override
	protected void init() {
		setTitle("Selecione um Business Controller");
		IProject project = Context.getCurrentInstance().getSelectedProject();
		this.models = ProjectHelper.getModels(project);
		JtConsole.log("%d models carregados para o projeto %s", models.size(), project.getName());
	}

	/**
	 * 
	 */
	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModelList = ModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return ModelHelper.hasAnnotationTypeName(model, "BusinessController");
			}
		});
		JtConsole.log("%d business controllers carregadas para o projeto %s", filteredModelList.size());
		return ModelHelper.asArray(filteredModelList);
	}

	/**
	 * 
	 */
	@Override
	protected LabelProvider getLabelProvider() {
		return new ModelLabelProvider();
	}

}
