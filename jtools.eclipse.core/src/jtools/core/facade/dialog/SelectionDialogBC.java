package jtools.core.facade.dialog;

import java.util.ArrayList;
import java.util.List;

import jtools.core.dialog.JtSelectionDialog;
import jtools.core.facade.Jt;
import jtools.core.model.JtModel;
import jtools.core.provider.JtModelLabelProvider;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class SelectionDialogBC extends JtSelectionDialog<JtModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	private IProject project;

	public SelectionDialogBC(IProject project, IWorkbenchWindow window) {
		super(window);
		this.project = project;
	}

	/**
	 * 
	 */
	@Override
	protected void init() {
		this.models = Jt.MODEL.getModels(this.project);
		Jt.CONSOLE.log("[%s] %d models carregados para o projeto %s", this.getClass().getName(), models.size(), project.getName());
	}

	/**
	 * 
	 */
	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModelList = Jt.MODEL.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return Jt.MODEL.hasAnnotationTypeName(model, "BusinessController");
			}
		});
		Jt.CONSOLE.log("[%s] %d business controllers carregadas para o projeto", this.getClass().getName(), filteredModelList.size());
		return Jt.MODEL.asArray(filteredModelList);
	}

	/**
	 * 
	 */
	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}

	@Override
	public String getTitle() {
		return "Selecione um Business Controller";
	}

}
