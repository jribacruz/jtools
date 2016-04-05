package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;

import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJavaPackage;
import jtools.eclipse.core.service.JtoolService;
import jtools.eclipse.core.util.JxCollection;

public class JxJavaPackageImpl implements JxJavaPackage {

	private JavaPackage javaPackage;

	public JxJavaPackageImpl(JavaPackage javaPackage) {
		this.javaPackage = javaPackage;
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
		for (JavaClass javaClass : this.javaPackage.getClasses()) {
			classes.add(new JxJavaClassImpl(javaClass));
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
		return new JxJavaPackageImpl(javaPackage.getParentPackage());
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
		for (JavaPackage javaPackage : this.javaPackage.getSubPackages()) {
			packages.add(new JxJavaPackageImpl(javaPackage));
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
		return null;
		//return new JxJavaPackageImpl(new File(FilenameUtils.normalize(getFileDir().getAbsolutePath().concat("/persistence"))));
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

	@Override
	public JavaPackage getJavaPackage() {
		return this.javaPackage;
	}

}
