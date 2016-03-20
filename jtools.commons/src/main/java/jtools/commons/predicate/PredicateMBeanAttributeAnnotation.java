package jtools.commons.predicate;

import jtools.commons.model.MClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMBeanAttributeAnnotation implements Predicate<MClassAttribute> {

	private String annotationName;

	public PredicateMBeanAttributeAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(MClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
