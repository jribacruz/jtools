package jtools.core.provider;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class ProjectLabelProvider extends LabelProvider {

	/**
	 * Retorna o icone padrão de um projeto.
	 */
	@Override
	public Image getImage(Object element) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(IDE.SharedImages.IMG_OBJ_PROJECT);
	}

	/**
	 * Retorna o nome do projeto no workspace.
	 */
	@Override
	public String getText(Object element) {
		IProject project = (IProject) element;
		return project.getName();
	}

}