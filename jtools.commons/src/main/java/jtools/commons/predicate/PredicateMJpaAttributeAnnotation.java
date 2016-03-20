package jtools.commons.predicate;

import jtools.commons.model.jpa.MJpaAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMJpaAttributeAnnotation implements Predicate<MJpaAttribute> {

	private String annotationName;

	public PredicateMJpaAttributeAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(MJpaAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
