package jtools.generator.eclipse.ui.model;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;

import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.JavaClass;

/**
 * 
 * @author jcruz
 *
 */
public interface JtModel extends Serializable {

	/**
	 * 
	 * Nome do package
	 * 
	 * @return
	 */
	public String getPackageName();

	/**
	 * 
	 * Nome da classe
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * 
	 * Lista dos relacionamentos da model.
	 * 
	 * @return
	 */
	public List<JtRelationship> getRelationships();

	/**
	 * 
	 * Lista dos atributos do model.
	 * 
	 * @return
	 */
	public List<JtAttribute> getAttributes();

	/**
	 * 
	 * @return
	 */
	public List<JtMethod> getMethods();

	/**
	 * 
	 * @return
	 */
	public Annotation[] getAnnotations();

	/**
	 * 
	 * @return
	 */
	public ICompilationUnit getCompilationUnit();

	/**
	 * 
	 * @return
	 */
	public JavaClass getJavaClass();

}
