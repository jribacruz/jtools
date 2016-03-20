package jtools.commons.internal.model.demoiselle.predicate;

import jtools.commons.model.MClass;

import com.google.common.base.Predicate;

public class PredicateIsMEditViewController implements Predicate<MClass> {

	@Override
	public boolean apply(MClass input) {
		return input.extendsOf("br.gov.frameworkdemoiselle.template.AbstractEditPageBean");
	}

}