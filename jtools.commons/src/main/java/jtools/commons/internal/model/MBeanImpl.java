package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.model.MBean;
import jtools.commons.model.MClassAttribute;
import jtools.commons.predicate.PredicateMBeanAttributeHasAnnotation;
import jtools.commons.predicate.PredicateMClassAttributeHasName;
import jtools.commons.types.TCollection;

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
	public TCollection<MClassAttribute> getInjectedAttributes() {
		return getAttributes().filter(new PredicateMBeanAttributeHasAnnotation("Inject"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#isInjectedAttribute(java.lang.String)
	 */
	@Override
	public boolean isInjectedAttribute(String attributeName) {
		return !getAttributes().filter(new PredicateMClassAttributeHasName(attributeName)).isEmpty();
	}

}
