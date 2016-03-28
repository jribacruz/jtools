package jtools.eclipse.core.internal.model.function;

import java.io.IOException;

import jtools.eclipse.core.internal.model.JxJpaEntityImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJpaEntity;

import com.google.common.base.Function;

public class FunctionJxClassToJxJpaEntity implements Function<JxJavaClass, JxJpaEntity> {

	@Override
	public JxJpaEntity apply(JxJavaClass input) {
		try {
			return new JxJpaEntityImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
