package jtools.eclipse.core.facade.dialog;

import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.dialog.JtSelectionDialog;
import jtools.eclipse.core.facade.Jt;
import jtools.eclipse.core.model.JtModel;
import jtools.eclipse.core.provider.JtModelLabelProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class SelectionDialogEntity extends JtSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	private IProject project;

	public SelectionDialogEntity(IProject project, IWorkbenchWindow window) {
		super(window);
		this.project = project;
	}

	@Override
	protected void init() {
		this.models = Jt.MODEL.getModels(this.project);
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
		filteredModels.removeAll(getSelectedList());
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
