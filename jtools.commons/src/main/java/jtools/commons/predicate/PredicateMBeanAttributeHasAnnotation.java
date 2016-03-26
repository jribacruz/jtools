package jtools.commons.predicate;

import jtools.commons.model.XClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateMBeanAttributeHasAnnotation implements Predicate<XClassAttribute> {

	private String annotationName;

	public PredicateMBeanAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(XClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
