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

public class ElementListSelectionDialogJpaEntity extends JtAbstractElementListSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	public ElementListSelectionDialogJpaEntity(IWorkbenchWindow window) {
		super(window);
	}

	@Override
	protected void init() {
		setTitle("Selecione uma entidade JPA");
		IProject project = Context.getCurrentInstance().getSelectedProject();
		this.models = ProjectHelper.getModels(project);
		JtConsole.log("[ElementListSelectionDialogJpaEntity] %d models carregados para o projeto %s", models.size(), project.getName());
	}

	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModels = JtModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return JtModelHelper.hasAnnotationTypeName(model, "Entity");
			}
		});
		JtConsole.log("[ElementListSelectionDialogJpaEntity] %d entities para o projeto", filteredModels.size());
		return JtModelHelper.asArray(filteredModels);
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}
}
