package jtools.commons.predicate;

import jtools.commons.model.jpa.XJpaAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMJpaAttributeHasAnnotation implements Predicate<XJpaAttribute> {

	private String annotationName;

	public PredicateMJpaAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(XJpaAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
