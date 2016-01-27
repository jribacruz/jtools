package jtools.generator.eclipse.ui.model;

import java.io.Serializable;

/**
 * 
 * @author jcruz
 *
 */
public interface Relationship extends Serializable {

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

}
