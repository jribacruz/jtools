package jtools.java.project.viewer.provider;

import org.eclipse.jdt.core.IJavaProject;
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
		IJavaProject project = (IJavaProject) element;
		return project.getProject().getName();
	}

}