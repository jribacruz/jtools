package jtools.eclipse.core.internal.model.function;

import com.google.common.base.Function;

import jtools.eclipse.core.internal.model.JxJpaEntityImpl;
import jtools.eclipse.core.model.JxJavaClass;
import jtools.eclipse.core.model.JxJpaEntity;
import jtools.eclipse.core.model.JxMavenProject;

public class FunctionJxClassToJxJpaEntity implements Function<JxJavaClass, JxJpaEntity> {

	private JxMavenProject mavenProject;

	public FunctionJxClassToJxJpaEntity(JxMavenProject mavenProject) {
		super();
		this.mavenProject = mavenProject;
	}

	@Override
	public JxJpaEntity apply(JxJavaClass input) {
		return new JxJpaEntityImpl(mavenProject, input.getJavaClass());
	}

}
