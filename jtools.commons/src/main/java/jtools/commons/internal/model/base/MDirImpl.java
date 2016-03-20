package jtools.commons.internal.model.base;

import java.io.File;

import jtools.commons.model.base.MDir;
import jtools.commons.model.base.MFile;
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
public class MDirImpl implements MDir {

	private File fileDir;

	public MDirImpl(File file) {
		super();
		this.fileDir = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getFiles()
	 */
	@Override
	public TCollection<MFile> getAllFiles() {
		return getAllFiles(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getAllFiles(boolean)
	 */
	@Override
	public TCollection<MFile> getAllFiles(boolean recursively) {
		return recursively ? getAllFiles(TrueFileFilter.INSTANCE) : getAllFiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getParent()
	 */
	@Override
	public MDir getParent() {
		return new MDirImpl(fileDir.getParentFile());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs()
	 */
	@Override
	public TCollection<MDir> getChildDirs() {
		return getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs(boolean)
	 */
	@Override
	public TCollection<MDir> getChildDirs(boolean recursively) {
		return recursively ? getChildDirs(TrueFileFilter.INSTANCE) : getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChild(java.lang.String)
	 */
	@Override
	public MDir getChild(final String dir) {
		MDir tmDir = getChildDirs(true).find(new Predicate<MDir>() {
			@Override
			public boolean apply(MDir input) {
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
	public <F extends IOFileFilter> TCollection<MFile> filter(F filter) {
		return filter(filter, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#filter(org.apache.commons.io.filefilter.
	 * AbstractFileFilter, boolean)
	 */
	@Override
	public <F extends IOFileFilter> TCollection<MFile> filter(F filter, boolean recursively) {
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
	private <F extends IOFileFilter, D extends IOFileFilter> TCollection<MFile> filter(F fileFilter, D dirFilter) {
		TCollection<MFile> ffiles = new TCollection<>();
		for (File filteredFile : FileUtils.listFilesAndDirs(getFileDir(), fileFilter, dirFilter)) {
			ffiles.add(new MFileImpl(filteredFile));
		}
		return ffiles;
	}

	/*
	 * 
	 */
	private TCollection<MFile> getAllFiles(IOFileFilter dirFilter) {
		TCollection<MFile> files = new TCollection<>();
		for (MFile file : filter(FileFileFilter.FILE, dirFilter)) {
			files.add(file);
		}
		return files;
	}

	/*
	 * 
	 */
	private TCollection<MDir> getChildDirs(IOFileFilter dirFilter) {
		TCollection<MDir> files = new TCollection<>();
		for (MFile file : filter(DirectoryFileFilter.DIRECTORY, dirFilter)) {
			files.add(new MDirImpl(file.getFile()));
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
		MDirImpl other = (MDirImpl) obj;
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
