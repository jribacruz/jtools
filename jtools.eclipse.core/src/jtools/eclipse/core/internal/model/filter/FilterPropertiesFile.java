package jtools.eclipse.core.internal.model.filter;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 
 * @author jcruz
 *
 */
public class FilterPropertiesFile extends SuffixFileFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilterPropertiesFile() {
		super(".properties");
	}

}