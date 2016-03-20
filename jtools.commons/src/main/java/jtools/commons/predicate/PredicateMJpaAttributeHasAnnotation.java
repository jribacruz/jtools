package jtools.commons.predicate;

import jtools.commons.model.jpa.MJpaAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMJpaAttributeHasAnnotation implements Predicate<MJpaAttribute> {

	private String annotationName;

	public PredicateMJpaAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(MJpaAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
