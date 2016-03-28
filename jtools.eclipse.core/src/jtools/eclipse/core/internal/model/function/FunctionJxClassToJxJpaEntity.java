package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxJpaEntityImpl;
import jtools.eclipse.core.model.JxClass;
import jtools.eclipse.core.model.JxJpaEntity;

import com.google.common.base.Function;

public class FunctionJxClassToJxJpaEntity implements Function<JxClass, JxJpaEntity> {

	@Override
	public JxJpaEntity apply(JxClass input) {
		try {
			return new JxJpaEntityImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
