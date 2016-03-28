package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateJxBeanAttributeHasAnnotation implements Predicate<JxClassAttribute> {

	private String annotationName;

	public PredicateJxBeanAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(JxClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
