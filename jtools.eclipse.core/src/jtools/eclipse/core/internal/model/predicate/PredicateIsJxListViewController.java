package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxClass;

import com.google.common.base.Predicate;

public class PredicateIsJxListViewController implements Predicate<JxClass> {

	@Override
	public boolean apply(JxClass input) {
		return input.extendsOf("br.gov.frameworkdemoiselle.template.AbstractListPageBean");
	}

}
