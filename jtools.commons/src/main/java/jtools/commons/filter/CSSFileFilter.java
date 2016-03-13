package jtools.commons.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * FilFilter para arquivos CSS(.css)
 * 
 * @author jcruz
 *
 */
public class CSSFileFilter extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CSSFileFilter() {
		super(".css");
	}

}
