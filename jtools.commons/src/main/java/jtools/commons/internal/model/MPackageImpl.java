package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.base.MDirImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.MPackage;
import jtools.commons.model.base.MDir;
import jtools.commons.model.base.MFile;
import jtools.commons.types.TCollection;

public class MPackageImpl extends MDirImpl implements MPackage {

	public MPackageImpl(File file) {
		super(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses()
	 */
	@Override
	public TCollection<MClass> getClasses() {
		return getClasses(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public TCollection<MClass> getClasses(boolean recursively) {
		TCollection<MClass> classes = new TCollection<>();
		for (MFile file : super.getAllFiles(recursively)) {
			if (file.isJavaFile()) {
				try {
					classes.add(new MClassImpl(file.getFile()));
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
	 * @see jtools.commons.model.TMPackage#getParentPackage()
	 */
	@Override
	public MPackage getParentPackage() {
		return new MPackageImpl(getParent().getFileDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public TCollection<MPackage> getChildPackages() {
		return getChildPackages(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public TCollection<MPackage> getChildPackages(boolean recursively) {
		TCollection<MPackage> packages = new TCollection<>();
		for (MDir dir : getChildDirs(recursively)) {
			packages.add(new MPackageImpl(dir.getFileDir()));
		}
		return packages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#find(java.lang.String)
	 */
	@Override
	public MPackage find(String packageName) {
		return null;
	}

}
