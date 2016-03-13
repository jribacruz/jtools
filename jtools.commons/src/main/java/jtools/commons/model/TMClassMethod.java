package jtools.commons.model;

import java.io.Serializable;

import com.thoughtworks.qdox.model.JavaMethod;

/**
 * Classe que representa um método Java.
 * 
 * @author jcruz
 *
 */
public interface TMClassMethod extends Serializable {

	/**
	 * Nome do método.
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * @return
	 */
	public JavaMethod getJavaMethod();
}
