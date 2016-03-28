package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxJavaClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateJxClassAttributeHasName implements Predicate<JxJavaClassAttribute> {

	private String attributeName;

	public PredicateJxClassAttributeHasName(String attributeName) {
		super();
		this.attributeName = attributeName;
	}

	@Override
	public boolean apply(JxJavaClassAttribute input) {
		return input.getName().equals(attributeName);
	}

}
