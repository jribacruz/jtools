package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import jtools.commons.model.TMClass;
import jtools.commons.model.TMPackage;
import jtools.commons.types.TCollection;

public class TMPackageImpl extends TMDirImpl implements TMPackage {

	public TMPackageImpl(File file) {
		super(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses()
	 */
	@Override
	public TCollection<TMClass> getClasses() {
		TCollection<TMClass> classes = new TCollection<>();
		for (File file : super.getFiles()) {
			if (FilenameUtils.isExtension(file.getAbsolutePath(), "java")) {
				try {
					classes.add(new TMClassImpl(file));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return classes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public TCollection<TMClass> getClasses(boolean recursively) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getParentPackage()
	 */
	@Override
	public TMPackage getParentPackage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public TCollection<TMPackage> getChildPackages() {
		return null;
	}

}
