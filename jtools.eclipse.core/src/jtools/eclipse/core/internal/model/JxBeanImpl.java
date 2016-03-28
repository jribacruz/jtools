package jtools.eclipse.core.internal.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.eclipse.core.internal.model.predicate.PredicateJxBeanAttributeHasAnnotation;
import jtools.eclipse.core.internal.model.predicate.PredicateJxClassAttributeHasName;
import jtools.eclipse.core.model.JxBean;
import jtools.eclipse.core.model.JxJavaClassAttribute;
import jtools.eclipse.core.util.JxCollection;

/**
 * 
 * @author jcruz
 *
 */
public class JxBeanImpl extends JxJavaClassImpl implements JxBean {
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
	public JxCollection<JxJavaClassAttribute> getInjectedAttributes() {
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
