package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxJavaClass;

import com.google.common.base.Predicate;

public class PredicateIsJxDemoiselleEditViewController implements Predicate<JxJavaClass> {

	@Override
	public boolean apply(JxJavaClass input) {
		return input.extendsOf("br.gov.frameworkdemoiselle.template.AbstractEditPageBean");
	}

}
