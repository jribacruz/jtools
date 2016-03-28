package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxPackage;
import jtools.eclipse.core.util.JxCollection;

public class JxPackageImpl extends JxDirImpl implements JxPackage {

	public JxPackageImpl(File file) {
		super(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses()
	 */
	@Override
	public JxCollection<JxClass> getClasses() {
		return getClasses(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public JxCollection<JxClass> getClasses(boolean recursively) {
		JxCollection<JxClass> classes = new JxCollection<>();
		for (JxFile file : super.getAllFiles(recursively)) {
			if (file.isJavaFile()) {
				try {
					classes.add(new JxClassImpl(file.getFile()));
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
	public JxPackage getParentPackage() {
		return new JxPackageImpl(getParent().getFileDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public JxCollection<JxPackage> getChildPackages() {
		return getChildPackages(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public JxCollection<JxPackage> getChildPackages(boolean recursively) {
		JxCollection<JxPackage> packages = new JxCollection<>();
		for (JxDir dir : getChildDirs(recursively)) {
			packages.add(new JxPackageImpl(dir.getFileDir()));
		}
		return packages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#find(java.lang.String)
	 */
	@Override
	public JxPackage find(String packageName) {
		return null;
	}

}
