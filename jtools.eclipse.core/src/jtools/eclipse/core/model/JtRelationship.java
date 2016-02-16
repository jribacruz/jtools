package jtools.eclipse.core.model;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface JtRelationship extends Serializable {

	/**
	 * 
	 * @return
	 */
	public boolean isComposition();

	/**
	 * 
	 * @return
	 */
	public boolean isOneToMany();

	/**
	 * 
	 * @return
	 */
	public boolean isManyToOne();

	/**
	 * 
	 * @return
	 */
	public boolean isManyToMany();

	/**
	 * 
	 * @return
	 */
	public boolean isOneToOne();
	
	/**
	 * 
	 * @return
	 */
	public JtModel getParentModel();

}
