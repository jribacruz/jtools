package jtools.commons.predicate;

import jtools.commons.model.XClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMClassAttributeHasName implements Predicate<XClassAttribute> {

	private String attributeName;

	public PredicateMClassAttributeHasName(String attributeName) {
		super();
		this.attributeName = attributeName;
	}

	@Override
	public boolean apply(XClassAttribute input) {
		return input.getName().equals(attributeName);
	}

}
