package jtools.generator.eclipse.ui.impl;

import java.util.ArrayList;
import java.util.List;

import jtools.eclipse.core.model.JtMethod;
import jtools.eclipse.core.model.JtModel;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

public class JtMethodImpl implements JtMethod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JavaMethod javaMethod;

	private JtModel parentModel;

	public JtMethodImpl(JavaMethod javaMethod, JtModel parentModel) {
		super();
		this.javaMethod = javaMethod;
		this.parentModel = parentModel;
	}

	@Override
	public String getName() {
		return javaMethod.getName();
	}

	@Override
	public String getReturnTypeName() {
		return null;
	}

	@Override
	public JavaMethod getJavaMethod() {
		return this.javaMethod;
	}

	@Override
	public Annotation[] getAnnotations() {
		return this.javaMethod.getAnnotations();
	}

	@Override
	public JtModel getParentModel() {
		return this.parentModel;
	}

	@Override
	public List<String> getParamentersTypeName() {
		List<String> paramTypeNameList = new ArrayList<>();

		for (JavaParameter param : javaMethod.getParameters()) {
			paramTypeNameList.add(param.getType().getJavaClass().getName());
		}

		return paramTypeNameList;
	}

}
