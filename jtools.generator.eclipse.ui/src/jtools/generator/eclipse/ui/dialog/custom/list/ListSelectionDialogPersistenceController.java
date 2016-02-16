package jtools.generator.eclipse.ui.dialog.custom.list;

import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.console.JtConsole;
import jtools.eclipse.core.model.JtModel;
import jtools.generator.eclipse.ui.dialog.core.JtAbstractListSelectionDialog;
import jtools.generator.eclipse.ui.dialog.providers.label.JtModelLabelProvider;
import jtools.generator.eclipse.ui.helper.JtModelHelper;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IWorkbenchWindow;

import com.google.common.base.Predicate;

public class ListSelectionDialogPersistenceController extends JtAbstractListSelectionDialog<JtModel> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private List<JtModel> models = new ArrayList<>();

	private IProject project;

	public ListSelectionDialogPersistenceController(IProject project, IWorkbenchWindow window) {
		super(window);
		this.project = project;
	}

	@Override
	protected void init() {
		this.models = JtModelHelper.getModels(project);
		JtConsole.log("[%s] %d models carregados para o projeto %s", this.getClass().getName(), models.size(), project.getName());

	}

	@Override
	protected JtModel[] getList() {
		List<JtModel> filteredModels = JtModelHelper.filterModels(models, new Predicate<JtModel>() {
			@Override
			public boolean apply(JtModel model) {
				return JtModelHelper.hasAnnotationTypeName(model, "PersistenceController");
			}
		});
		JtConsole.log("[%s] %d persistence controllers carregadas para o projeto", this.getClass().getName(), filteredModels.size());
		return JtModelHelper.asArray(filteredModels);
	}

	@Override
	protected LabelProvider getLabelProvider() {
		return new JtModelLabelProvider();
	}

	@Override
	public String getTitle() {
		return "Selecione um Persistence Controller";
	}
}
