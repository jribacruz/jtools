package jtools.commons.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 
 * @author jcruz
 *
 */
public class FilterHTMLFile extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterHTMLFile() {
		super(".html");
	}

}
