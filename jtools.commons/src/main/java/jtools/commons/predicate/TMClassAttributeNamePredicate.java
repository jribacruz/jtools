package jtools.commons.predicate;

import jtools.commons.model.TMClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class TMClassAttributeNamePredicate implements Predicate<TMClassAttribute> {

	private String attributeName;

	public TMClassAttributeNamePredicate(String attributeName) {
		super();
		this.attributeName = attributeName;
	}

	@Override
	public boolean apply(TMClassAttribute input) {
		return input.getName().equals(attributeName);
	}

}
