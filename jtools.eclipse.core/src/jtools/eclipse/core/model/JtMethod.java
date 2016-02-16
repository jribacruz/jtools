package jtools.eclipse.core.model;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaMethod;

public interface JtMethod extends Serializable {

	/**
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public String getReturnTypeName();

	/**
	 * 
	 * @return
	 */
	public JavaMethod getJavaMethod();

	/**
	 * 
	 * @return
	 */
	public Annotation[] getAnnotations();

	/**
	 * 
	 * @return
	 */
	public JtModel getParentModel();

	/**
	 * 
	 * @return
	 */
	public List<String> getParamentersTypeName();
}
