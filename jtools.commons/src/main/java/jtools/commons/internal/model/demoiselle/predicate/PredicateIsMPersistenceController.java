package jtools.commons.internal.model.demoiselle.predicate;

import jtools.commons.model.XClass;

import com.google.common.base.Predicate;

public class PredicateIsMPersistenceController implements Predicate<XClass> {

	@Override
	public boolean apply(XClass input) {
		return input.hasAnnotation("PersistenceController");
	}

}
