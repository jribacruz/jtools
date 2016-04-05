package jtools.eclipse.core.internal.model;

import java.io.File;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.model.JxDir;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.util.JxCollection;

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
public class JxDirImpl implements JxDir {

	private File fileDir;

	public JxDirImpl(File file) {
		super();
		this.fileDir = file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getFiles()
	 */
	@Override
	public JxCollection<JxFile> getAllFiles() {
		return getAllFiles(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getAllFiles(boolean)
	 */
	@Override
	public JxCollection<JxFile> getAllFiles(boolean recursively) {
		return recursively ? getAllFiles(TrueFileFilter.INSTANCE) : getAllFiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getParent()
	 */
	@Override
	public JxDir getParent() {
		return new JxDirImpl(fileDir.getParentFile());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs()
	 */
	@Override
	public JxCollection<JxDir> getChildDirs() {
		return getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChildDirs(boolean)
	 */
	@Override
	public JxCollection<JxDir> getChildDirs(boolean recursively) {
		return recursively ? getChildDirs(TrueFileFilter.INSTANCE) : getChildDirs(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#getChild(java.lang.String)
	 */
	@Override
	public JxDir getChild(final String dir) throws JxElementNotFoundException {
		JxDir tmDir = getChildDirs(true).find(new Predicate<JxDir>() {
			@Override
			public boolean apply(JxDir input) {
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
	public <F extends IOFileFilter> JxCollection<JxFile> filter(F filter) {
		return filter(filter, TrueFileFilter.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMDir#filter(org.apache.commons.io.filefilter.
	 * AbstractFileFilter, boolean)
	 */
	@Override
	public <F extends IOFileFilter> JxCollection<JxFile> filter(F filter, boolean recursively) {
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
	private <F extends IOFileFilter, D extends IOFileFilter> JxCollection<JxFile> filter(F fileFilter, D dirFilter) {
		JxCollection<JxFile> ffiles = new JxCollection<>();
		for (File filteredFile : FileUtils.listFilesAndDirs(getFileDir(), fileFilter, dirFilter)) {
			ffiles.add(new JxFileImpl(filteredFile));
		}
		return ffiles;
	}

	/*
	 * 
	 */
	private JxCollection<JxFile> getAllFiles(IOFileFilter dirFilter) {
		JxCollection<JxFile> files = new JxCollection<>();
		for (JxFile file : filter(FileFileFilter.FILE, dirFilter)) {
			files.add(file);
		}
		return files;
	}

	/*
	 * 
	 */
	private JxCollection<JxDir> getChildDirs(IOFileFilter dirFilter) {
		JxCollection<JxDir> files = new JxCollection<>();
		for (JxFile file : filter(DirectoryFileFilter.DIRECTORY, dirFilter)) {
			files.add(new JxDirImpl(file.getFile()));
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
		JxDirImpl other = (JxDirImpl) obj;
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
