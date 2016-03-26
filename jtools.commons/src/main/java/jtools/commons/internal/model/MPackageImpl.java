package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.base.MDirImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.XPackage;
import jtools.commons.model.base.XDir;
import jtools.commons.model.base.XFile;
import jtools.commons.types.XCollection;

public class MPackageImpl extends MDirImpl implements XPackage {

	public MPackageImpl(File file) {
		super(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses()
	 */
	@Override
	public XCollection<XClass> getClasses() {
		return getClasses(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public XCollection<XClass> getClasses(boolean recursively) {
		XCollection<XClass> classes = new XCollection<>();
		for (XFile file : super.getAllFiles(recursively)) {
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
	public XPackage getParentPackage() {
		return new MPackageImpl(getParent().getFileDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public XCollection<XPackage> getChildPackages() {
		return getChildPackages(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public XCollection<XPackage> getChildPackages(boolean recursively) {
		XCollection<XPackage> packages = new XCollection<>();
		for (XDir dir : getChildDirs(recursively)) {
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
	public XPackage find(String packageName) {
		return null;
	}

}
