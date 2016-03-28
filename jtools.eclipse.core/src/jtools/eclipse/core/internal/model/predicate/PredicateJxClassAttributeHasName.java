package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateJxClassAttributeHasName implements Predicate<JxClassAttribute> {

	private String attributeName;

	public PredicateJxClassAttributeHasName(String attributeName) {
		super();
		this.attributeName = attributeName;
	}

	@Override
	public boolean apply(JxClassAttribute input) {
		return input.getName().equals(attributeName);
	}

}
