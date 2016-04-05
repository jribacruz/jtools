package jtools.eclipse.core.internal.model;

import com.thoughtworks.qdox.model.JavaClass;

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

	public JxBeanImpl(JavaClass javaClass) {
		super(javaClass);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#getAttributeInjections()
	 */
	@Override
	public JxCollection<JxJavaClassAttribute> findAllInjectedAttributes() {
		return findAllAttributes().filter(new PredicateJxBeanAttributeHasAnnotation("Inject"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMBean#isInjectedAttribute(java.lang.String)
	 */
	@Override
	public boolean isInjectedAttribute(String attributeName) {
		return !findAllAttributes().filter(new PredicateJxClassAttributeHasName(attributeName)).isEmpty();
	}

}
