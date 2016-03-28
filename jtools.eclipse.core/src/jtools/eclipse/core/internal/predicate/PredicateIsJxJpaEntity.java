package jtools.eclipse.core.internal.predicate;

import jtools.eclipse.core.model.JxClass;

import com.google.common.base.Predicate;

public class PredicateIsJxJpaEntity implements Predicate<JxClass> {

	@Override
	public boolean apply(JxClass input) {
		return input.hasAnnotation("Entity");
	}

}
