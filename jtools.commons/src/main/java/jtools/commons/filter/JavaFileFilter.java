package jtools.commons.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

public class JavaFileFilter extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JavaFileFilter() {
		super(".java");
	}

}
