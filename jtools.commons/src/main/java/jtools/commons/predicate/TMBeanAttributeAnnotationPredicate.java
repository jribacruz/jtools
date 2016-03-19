package jtools.commons.predicate;

import jtools.commons.model.TMClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class TMBeanAttributeAnnotationPredicate implements Predicate<TMClassAttribute> {

	private String annotationName;

	public TMBeanAttributeAnnotationPredicate(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(TMClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
