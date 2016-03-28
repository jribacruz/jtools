package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxJavaClassAttribute;

import com.google.common.base.Predicate;

/**
 * 
 * @author jcruz
 *
 */
public class PredicateJxBeanAttributeHasAnnotation implements Predicate<JxJavaClassAttribute> {

	private String annotationName;

	public PredicateJxBeanAttributeHasAnnotation(String annotationName) {
		super();
		this.annotationName = annotationName;
	}

	@Override
	public boolean apply(JxJavaClassAttribute input) {
		return input.hasAnnotation(annotationName);
	}

}
