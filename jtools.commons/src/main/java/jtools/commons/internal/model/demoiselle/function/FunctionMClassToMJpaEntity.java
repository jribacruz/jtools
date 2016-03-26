package jtools.commons.internal.model.demoiselle.function;

import java.io.IOException;

import jtools.commons.internal.model.jpa.MJpaEntityImpl;
import jtools.commons.model.XClass;
import jtools.commons.model.jpa.XJpaEntity;

import com.google.common.base.Function;

public class FunctionMClassToMJpaEntity implements Function<XClass, XJpaEntity> {

	@Override
	public XJpaEntity apply(XClass input) {
		try {
			return new MJpaEntityImpl(input.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
