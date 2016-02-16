package jtools.eclipse.core.util;

import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class JtUI {

	public static Image getImage(String bundleId, String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, path).createImage();
	}
}
