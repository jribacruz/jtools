package jtools.generator.eclipse.ui.dialog.custom;

import java.util.ArrayList;
import java.util.List;

import jtools.generator.eclipse.ui.context.Context;
import jtools.generator.eclipse.ui.context.JtConsole;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractElementListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.JtModelLabelProvider;
import jtools.generator.eclipse.ui.helper.JtModelHelper;
import jtools.generator.eclipse.ui.helper.ProjectHelper;
import jtools.generator.eclipse.ui.model.JtModel;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class ElementListSelectionDialogPersistenceController extends JtAbstractElementListSelectionDialog<JtModel> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	public ElementListSelectionDialogPersistenceController(IWorkbenchWindow window) {
		super(window);
	}

	@Override
	protected void init() {
		setTitle("Selecione um Persistence Controller");
		IProject project = Context.getCurrentInstance().getSelectedProject();
		this.models = ProjectHelper.getModels(project);
		JtConsole.log("[ElementListSelectionDialogPersistenceController] %d models carregados para o projeto %s", models.size(),
				project.getName());

	}

	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModels = JtModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return JtModelHelper.hasAnnotationTypeName(model, "PersistenceController");
			}
		});
		JtConsole.log("[ElementListSelectionDialogPersistenceController] %d persistence controllers carregadas para o projeto",
				filteredModels.size());
		return JtModelHelper.asArray(filteredModels);
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}
}
