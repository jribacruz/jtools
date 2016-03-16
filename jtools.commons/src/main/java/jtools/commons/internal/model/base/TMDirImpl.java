package jtools.commons.internal.model.base;

import java.io.File;

import jtools.commons.model.base.TMDir;
import jtools.commons.model.base.TMFile;
import jtools.commons.types.TCollection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class TMDirImpl implements TMDir {

	private File fileDir;

	public TMDirImpl(File file) {
		super();
		this.fileDir = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getFiles()
	 */
	@Override
	public TCollection<TMFile> getAllFiles() {
		return getAllFiles(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getAllFiles(boolean)
	 */
	@Override
	public TCollection<TMFile> getAllFiles(boolean recursively) {
		return recursively ? getAllFiles(TrueFileFilter.INSTANCE) : getAllFiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getParent()
	 */
	@Override
	public TMDir getParent() {
		return new TMDirImpl(fileDir.getParentFile());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs()
	 */
	@Override
	public TCollection<TMDir> getChildDirs() {
		return getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs(boolean)
	 */
	@Override
	public TCollection<TMDir> getChildDirs(boolean recursively) {
		return recursively ? getChildDirs(TrueFileFilter.INSTANCE) : getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChild(java.lang.String)
	 */
	@Override
	public TMDir getChild(final String dir) {
		TMDir tmDir = getChildDirs(true).find(new Predicate<TMDir>() {
			@Override
			public boolean apply(TMDir input) {
				return input.getFileDir().getName().equals(dir);
			}
		});
		return tmDir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#filter(org.apache.commons.io.filefilter.
	 * AbstractFileFilter)
	 */
	@Override
	public <F extends IOFileFilter> TCollection<TMFile> filter(F filter) {
		return filter(filter, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#filter(org.apache.commons.io.filefilter.
	 * AbstractFileFilter, boolean)
	 */
	@Override
	public <F extends IOFileFilter> TCollection<TMFile> filter(F filter, boolean recursively) {
		return recursively ? filter(filter, TrueFileFilter.INSTANCE) : filter(filter, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getFileDir()
	 */
	@Override
	public File getFileDir() {
		return this.fileDir;
	}

	/*
	 * 
	 */
	private <F extends IOFileFilter, D extends IOFileFilter> TCollection<TMFile> filter(F fileFilter, D dirFilter) {
		TCollection<TMFile> ffiles = new TCollection<>();
		for (File filteredFile : FileUtils.listFilesAndDirs(getFileDir(), fileFilter, dirFilter)) {
			ffiles.add(new TMFileImpl(filteredFile));
		}
		return ffiles;
	}

	/*
	 * 
	 */
	private TCollection<TMFile> getAllFiles(IOFileFilter dirFilter) {
		TCollection<TMFile> files = new TCollection<>();
		for (TMFile file : filter(FileFileFilter.FILE, dirFilter)) {
			files.add(file);
		}
		return files;
	}

	/*
	 * 
	 */
	private TCollection<TMDir> getChildDirs(IOFileFilter dirFilter) {
		TCollection<TMDir> files = new TCollection<>();
		for (TMFile file : filter(DirectoryFileFilter.DIRECTORY, dirFilter)) {
			files.add(new TMDirImpl(file.getFile()));
		}
		return files;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileDir == null) ? 0 : fileDir.hashCode());
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
		if (fileDir == null) {
			if (other.fileDir != null)
				return false;
		} else if (!fileDir.equals(other.fileDir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TMDirImpl [file=" + fileDir + "]";
	}

}
