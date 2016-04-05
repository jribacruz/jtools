package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.google.common.base.Predicate;

import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxJavaPackage;
import jtools.eclipse.core.util.JxCollection;

public class JxJavaPackageImpl extends JxDirImpl implements JxJavaPackage {

	public JxJavaPackageImpl(File file) {
		super(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses()
	 */
	@Override
	public JxCollection<JxJavaClass> findAllChildClasses() {
		return findAllChildClasses(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public JxCollection<JxJavaClass> findAllChildClasses(boolean recursively) {
		JxCollection<JxJavaClass> classes = new JxCollection<>();
		for (JxFile file : super.getAllFiles(recursively)) {
			if (file.isJavaFile()) {
				try {
					classes.add(new JxJavaClassImpl(file.getFile()));
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
	public JxJavaPackage getParentPackage() {
		return new JxJavaPackageImpl(getParent().getFileDir());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages()
	 */
	@Override
	public JxCollection<JxJavaPackage> findAllChildPackages() {
		return findAllChildPackages(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public JxCollection<JxJavaPackage> findAllChildPackages(boolean recursively) {
		JxCollection<JxJavaPackage> packages = new JxCollection<>();
		for (JxDir dir : getChildDirs(recursively)) {
			packages.add(new JxJavaPackageImpl(dir.getFileDir()));
		}
		return packages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#find(java.lang.String)
	 */
	@Override
	public JxJavaPackage find(String packageName) {
		return new JxJavaPackageImpl(new File(FilenameUtils.normalize(getFileDir().getAbsolutePath().concat("/persistence"))));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaPackage#findClass(com.google.common.base.Predicate)
	 */
	@Override
	public JxJavaClass findChildClass(Predicate<JxJavaClass> predicate) {
		return findAllChildClasses().find(predicate);
	}

}
