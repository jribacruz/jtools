package jtools.eclipse.core.internal.model.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * FilFilter para arquivos CSS(.css)
 * 
 * @author jcruz
 *
 */
public class FilterCSSFile extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterCSSFile() {
		super(".css");
	}

}
