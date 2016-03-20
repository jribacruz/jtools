package jtools.commons.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 
 * @author jcruz
 *
 */
public class FilterXHTMLFile extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterXHTMLFile() {
		super(".xhtml");
	}

}
