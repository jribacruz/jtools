package jtools.eclipse.core.internal.model.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * FileFilter para arquivos javascripts (.js).
 * 
 * @author jcruz
 *
 */
public class FilterJSFile extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterJSFile() {
		super(".js");
	}

}
