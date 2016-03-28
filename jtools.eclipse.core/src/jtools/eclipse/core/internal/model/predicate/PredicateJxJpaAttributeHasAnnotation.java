package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxJpaAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateJxJpaAttributeHasAnnotation implements Predicate<JxJpaAttribute> {

	private String annotationName;

	public PredicateJxJpaAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(JxJpaAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
