package jtools.commons.predicate;

import jtools.commons.model.MClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMClassAttributeHasName implements Predicate<MClassAttribute> {

	private String attributeName;

	public PredicateMClassAttributeHasName(String attributeName) {
		super();
		this.attributeName = attributeName;
	}

	@Override
	public boolean apply(MClassAttribute input) {
		return input.getName().equals(attributeName);
	}

}
