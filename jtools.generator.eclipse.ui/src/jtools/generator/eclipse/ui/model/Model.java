package jtools.generator.eclipse.ui.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author jcruz
 *
 */
public interface Model extends Serializable {

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
	public List<Relationship> getRelationships();

	/**
	 * 
	 * Lista dos atributos do model.
	 * 
	 * @return
	 */
	public List<Attribute> getAttributes();

}
