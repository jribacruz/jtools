package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.jpa.MJpaEntityImpl;
import jtools.commons.model.MClass;
import jtools.commons.model.jpa.MJpaEntity;

import com.google.common.base.Function;

public class FunctionMJpaEntity implements Function<MClass, MJpaEntity> {

	@Override
	public MJpaEntity apply(MClass input) {
		try {
			return new MJpaEntityImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
