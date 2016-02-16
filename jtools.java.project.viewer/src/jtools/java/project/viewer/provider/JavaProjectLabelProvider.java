package jtools.java.project.viewer.provider;

import jtools.eclipse.core.util.JtUI;
import jtools.java.project.viewer.Activator;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class JavaProjectLabelProvider extends LabelProvider {

	/**
	 * Retorna o icone padrão de um projeto.
	 */
	@Override
	public Image getImage(Object element) {
		return JtUI.getImage(Activator.PLUGIN_ID, "/icons/folder.png");
	}

	/**
	 * Retorna o nome do projeto no workspace.
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IJavaProject) {
			IJavaProject project = (IJavaProject) element;
			return project.getProject().getName();
		} else if (element instanceof IPackageFragmentRoot) {
			IPackageFragmentRoot fragmentRoot = (IPackageFragmentRoot) element;
			String fragmentRootName = fragmentRoot.getElementName();
			if (!fragmentRootName.endsWith(".jar")) {
				return fragmentRootName;
			}
		}
		return "";
	}

}