package jtools.commons.predicate;

import jtools.commons.model.TMJpaAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class TMJpaAttributeAnnotationPredicate implements Predicate<TMJpaAttribute> {

	private String annotationName;

	public TMJpaAttributeAnnotationPredicate(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(TMJpaAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
