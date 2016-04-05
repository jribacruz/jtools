package jtools.eclipse.core.internal.model;

import com.google.common.base.Predicate;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaPackage;

import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJavaPackage;
import jtools.eclipse.core.util.JxCollection;

public class JxJavaPackageImpl implements JxJavaPackage {

	private JavaPackage javaPackage;

	public JxJavaPackageImpl(JavaPackage javaPackage) {
		this.javaPackage = javaPackage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaPackage#getPackageName()
	 */
	@Override
	public String getPackageName() {
		return javaPackage.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMPackage#getClasses(boolean)
	 */
	@Override
	public JxCollection<JxJavaClass> findAllClasses() {
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
	 * @see jtools.commons.model.TMPackage#getChildPackages(boolean)
	 */
	@Override
	public JxCollection<JxJavaPackage> findAllSubPackages() {
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
	public JxJavaPackage findSubPackageByName(String packageName) {
		for (JxJavaPackage javaPackage : findAllSubPackages()) {
			if (getPackageName().endsWith(packageName)) {
				return javaPackage;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaPackage#findClass(com.google.common.base.Predicate)
	 */
	@Override
	public JxJavaClass findClass(Predicate<JxJavaClass> predicate) {
		return findAllClasses().find(predicate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaPackage#getJavaPackage()
	 */
	@Override
	public JavaPackage getJavaPackage() {
		return this.javaPackage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.eclipse.core.model.JxJavaPackage#findSubPackageByName(com.google.common.base.Predicate)
	 */
	@Override
	public JxJavaPackage findSubPackageByName(Predicate<JxJavaPackage> predicate) {
		for (JxJavaPackage javaPackage : findAllSubPackages()) {
			if (predicate.apply(javaPackage)) {
				return javaPackage;
			}
		}
		return null;
	}

}
