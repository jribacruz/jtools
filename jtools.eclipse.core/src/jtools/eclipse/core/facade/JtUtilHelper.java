package jtools.eclipse.core.facade;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

public class JtUtilHelper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Carrega uma imagem de um plugin.
	 * 
	 * @param bundleId
	 *            Id do plugin
	 * @param path
	 *            Caminho da imagem
	 * @return Imagem
	 */
	public Image getImage(String bundleId, String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, path).createImage();
	}

	/**
	 * 
	 * Carrega um arquivo armazenado do bundle.
	 * 
	 * @param bundleId
	 * @param location
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public File getFile(String bundleId, String location) {
		Bundle bundle = Platform.getBundle(bundleId);
		URL fileURL = bundle.getEntry(location);
		File file;
		try {
			file = new File(FileLocator.resolve(fileURL).toURI());
			return file;
		} catch (URISyntaxException e) {
			Jt.MESSAGE.error(e.getMessage());
		} catch (IOException e) {
			Jt.MESSAGE.error(e.getMessage());
		}
		return null;
	}

}
