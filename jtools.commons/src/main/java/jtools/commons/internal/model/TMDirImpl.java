package jtools.commons.internal.model;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AbstractFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import com.google.common.base.Predicate;

import jtools.commons.model.TMDir;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public class TMDirImpl implements TMDir {

	private File file;

	public TMDirImpl(File file) {
		super();
		this.file = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getFiles()
	 */
	@Override
	public TCollection<File> getFiles() {
		TCollection<File> files = new TCollection<>();
		for (File ffile : file.listFiles()) {
			if (ffile.isFile()) {
				files.add(ffile);
			}
		}
		return files;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getParent()
	 */
	@Override
	public TMDir getParent() {
		return new TMDirImpl(file.getParentFile());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs()
	 */
	@Override
	public TCollection<TMDir> getChildDirs() {
		TCollection<TMDir> dirs = new TCollection<>();
		for (File dir : file.listFiles()) {
			if (dir.isDirectory()) {
				dirs.add(new TMDirImpl(dir));
			}
		}
		return dirs;
	}

	@Override
	public TCollection<File> getFiles(boolean recursively) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChild(java.lang.String)
	 */
	@Override
	public TMDir getChild(final String dir) {
		TMDir tmDir = getChildDirs().find(new Predicate<TMDir>() {
			@Override
			public boolean apply(TMDir input) {
				return input.getFileDir().getName().equals(dir);
			}
		});
		return tmDir;
	}

	@Override
	public <F extends AbstractFileFilter> TCollection<File> filter(F filter) {
		TCollection<File> ffiles = new TCollection<>();
		for (File filteredFile : FileUtils.listFiles(getFileDir(), filter, TrueFileFilter.INSTANCE)) {
			ffiles.add(filteredFile);
		}
		return ffiles;
	}

	@Override
	public File getFileDir() {
		return this.file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TMDirImpl other = (TMDirImpl) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TMDirImpl [file=" + file + "]";
	}

}
