package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import jtools.commons.model.TMBean;
import jtools.commons.model.TMClassAttribute;
import jtools.commons.predicate.TMBeanAttributeAnnotationPredicate;
import jtools.commons.predicate.TMClassAttributeNamePredicate;

/**
 * 
 * @author jcruz
 *
 */
public class TMBeanImpl extends TMClassImpl implements TMBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TMBeanImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#getAttributeInjections()
	 */
	@Override
	public Collection<TMClassAttribute> getInjectedAttributes() {
		return getAttributes().filter(new TMBeanAttributeAnnotationPredicate("Inject"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#isInjectedAttribute(java.lang.String)
	 */
	@Override
	public boolean isInjectedAttribute(String attributeName) {
		return !getAttributes().filter(new TMClassAttributeNamePredicate(attributeName)).isEmpty();
	}

}
