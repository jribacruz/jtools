package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxJpaEntityImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJpaEntity;

public class FunctionJxClassToJxJpaEntity implements Function<JxJavaClass, JxJpaEntity> {

	@Override
	public JxJpaEntity apply(JxJavaClass input) {
		return new JxJpaEntityImpl(input.getJavaClass());
	}

}
