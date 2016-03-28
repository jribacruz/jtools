package jtools.eclipse.core.internal.model.predicate;

import jtools.eclipse.core.model.JxJavaClass;

import com.google.common.base.Predicate;

public class PredicateIsJxDemoisellePersistenceController implements Predicate<JxJavaClass> {

	@Override
	public boolean apply(JxJavaClass input) {
		return input.hasAnnotation("PersistenceController");
	}

}
