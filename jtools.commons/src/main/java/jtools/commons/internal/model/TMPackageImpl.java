package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.base.TMDirImpl;
import jtools.commons.model.TMClass;
import jtools.commons.model.TMPackage;
import jtools.commons.model.base.TMDir;
import jtools.commons.model.base.TMFile;
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
		return getClasses(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public TCollection<TMClass> getClasses(boolean recursively) {
		TCollection<TMClass> classes = new TCollection<>();
		for (TMFile file : super.getAllFiles(recursively)) {
			if (file.isJavaFile()) {
				try {
					classes.add(new TMClassImpl(file.getFile()));
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
	public TMPackage getParentPackage() {
		return new TMPackageImpl(getParent().getFileDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public TCollection<TMPackage> getChildPackages() {
		return getChildPackages(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public TCollection<TMPackage> getChildPackages(boolean recursively) {
		TCollection<TMPackage> packages = new TCollection<>();
		for (TMDir dir : getChildDirs(recursively)) {
			packages.add(new TMPackageImpl(dir.getFileDir()));
		}
		return packages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#find(java.lang.String)
	 */
	@Override
	public TMPackage find(String packageName) {
		return null;
	}

}
