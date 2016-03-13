package jtools.commons.internal.model;

import java.io.File;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChild(java.lang.String)
	 */
	@Override
	public TMDir getChild(String dir) {
		File childDir = new File(file.getAbsolutePath() + "dir");
		return null;
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
