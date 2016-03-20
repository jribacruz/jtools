package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import jtools.commons.model.MBean;
import jtools.commons.model.MClassAttribute;
import jtools.commons.predicate.PredicateMBeanAttributeAnnotation;
import jtools.commons.predicate.PredicateMClassAttributeName;

/**
 * 
 * @author jcruz
 *
 */
public class MBeanImpl extends MClassImpl implements MBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MBeanImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#getAttributeInjections()
	 */
	@Override
	public Collection<MClassAttribute> getInjectedAttributes() {
		return getAttributes().filter(new PredicateMBeanAttributeAnnotation("Inject"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#isInjectedAttribute(java.lang.String)
	 */
	@Override
	public boolean isInjectedAttribute(String attributeName) {
		return !getAttributes().filter(new PredicateMClassAttributeName(attributeName)).isEmpty();
	}

}
