package jtools.commons.predicate;

import jtools.commons.model.MClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMBeanAttributeHasAnnotation implements Predicate<MClassAttribute> {

	private String annotationName;

	public PredicateMBeanAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(MClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
