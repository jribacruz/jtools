package jtools.commons.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.model.XBean;
import jtools.commons.model.XClassAttribute;
import jtools.commons.predicate.PredicateMBeanAttributeHasAnnotation;
import jtools.commons.predicate.PredicateMClassAttributeHasName;
import jtools.commons.types.XCollection;

/**
 * 
 * @author jcruz
 *
 */
public class MBeanImpl extends MClassImpl implements XBean {
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
	public XCollection<XClassAttribute> getInjectedAttributes() {
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
