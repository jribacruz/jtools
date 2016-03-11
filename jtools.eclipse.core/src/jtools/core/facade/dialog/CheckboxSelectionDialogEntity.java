package jtools.core.facade.dialog;

import java.util.ArrayList;
import java.util.List;

import jtools.core.dialog.JtCheckboxSelectionDialog;
import jtools.core.facade.Jt;
import jtools.core.model.JtModel;
import jtools.core.provider.JtModelLabelProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class CheckboxSelectionDialogEntity extends JtCheckboxSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	private IProject project;

	public CheckboxSelectionDialogEntity(IProject project, IWorkbenchWindow window) {
		super(window);
		this.project = project;
	}

	@Override
	protected void init() {
		this.models = Jt.MODEL.getModels(project);
		Jt.CONSOLE.log("[%s] %d models carregados para o projeto %s", this.getClass().getName(), models.size(), project.getName());
	}

	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModels = Jt.MODEL.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return Jt.MODEL.hasAnnotationTypeName(model, "Entity");
			}
		});
		Jt.CONSOLE.log("[%s] %d entities para o projeto", this.getClass().getName(), filteredModels.size());
		return Jt.MODEL.asArray(filteredModels);
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