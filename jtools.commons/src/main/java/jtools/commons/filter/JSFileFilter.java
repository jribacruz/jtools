package jtools.commons.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * File Filter para arquivos javascripts (.js).
 * 
 * @author jcruz
 *
 */
public class JSFileFilter extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JSFileFilter() {
		super(".js");
	}

}
