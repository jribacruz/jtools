package jtools.core.facade;

import java.io.Serializable;

import jtools.core.Activator;

import org.eclipse.swt.graphics.Image;

public class JtImages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String IMG_FOLDER = "icons/";

	public final static Image CLASS_OBJ = Jt.UTIL.getImage(Activator.PLUGIN_ID, IMG_FOLDER + "class_obj.gif");

}
