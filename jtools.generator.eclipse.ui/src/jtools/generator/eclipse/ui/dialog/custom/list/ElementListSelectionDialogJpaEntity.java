package jtools.generator.eclipse.ui.dialog.custom.list;

import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.facade.Jt;
import jtools.eclipse.core.model.JtModel;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractElementListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.label.JtModelLabelProvider;
import jtools.generator.eclipse.ui.helper.JtModelHelper;

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

	private IProject project;

	public ElementListSelectionDialogJpaEntity(IProject project, IWorkbenchWindow window) {
		super(window);
		this.project = project;
	}

	@Override
	protected void init() {
		this.models = JtModelHelper.getModels(this.project);
		Jt.CONSOLE.log("[%s] %d models carregados para o projeto %s", this.getClass().getName(), models.size(), project.getName());
	}

	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModels = JtModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return JtModelHelper.hasAnnotationTypeName(model, "Entity");
			}
		});
		filteredModels.removeAll(getSelectedList());
		Jt.CONSOLE.log("[%s] %d entities para o projeto", this.getClass().getName(), filteredModels.size());
		return JtModelHelper.asArray(filteredModels);
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}

	@Override
	public String getTitle() {
		return "Selecione uma entidade JPA";
	}
}
