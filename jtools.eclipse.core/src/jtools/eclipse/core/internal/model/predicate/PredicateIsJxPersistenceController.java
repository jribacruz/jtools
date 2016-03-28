package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxClass;

import com.google.common.base.Predicate;

public class PredicateIsJxPersistenceController implements Predicate<JxClass> {

	@Override
	public boolean apply(JxClass input) {
		return input.hasAnnotation("PersistenceController");
	}

}
