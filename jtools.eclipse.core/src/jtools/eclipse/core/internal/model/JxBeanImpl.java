package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.XCollection;
import jtools.eclipse.core.internal.predicate.PredicateJxBeanAttributeHasAnnotation;
import jtools.eclipse.core.internal.predicate.PredicateJxClassAttributeHasName;
import jtools.eclipse.core.model.JxBean;
import jtools.eclipse.core.model.JxClassAttribute;

/**
 * 
 * @author jcruz
 *
 */
public class JxBeanImpl extends JxClassImpl implements JxBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxBeanImpl(File javaFile) throws FileNotFoundException, IOException {
		super(javaFile);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#getAttributeInjections()
	 */
	@Override
	public XCollection<JxClassAttribute> getInjectedAttributes() {
		return getAttributes().filter(new PredicateJxBeanAttributeHasAnnotation("Inject"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#isInjectedAttribute(java.lang.String)
	 */
	@Override
	public boolean isInjectedAttribute(String attributeName) {
		return !getAttributes().filter(new PredicateJxClassAttributeHasName(attributeName)).isEmpty();
	}

}