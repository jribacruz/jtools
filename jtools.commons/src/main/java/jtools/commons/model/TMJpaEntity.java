package jtools.commons.model;

import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface TMJpaEntity extends TMClass {

	/**
	 * Retorna o atributo Id
	 * 
	 * @return
	 */
	public TMJpaAttribute getId();
	
	/**
	 * 
	 * @return
	 */
	public boolean isInheritance();

	/**
	 * 
	 * @return
	 */
	public String getTableName();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaAttribute> getUniOneToMany();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaAttribute> getUniOneToOne();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaAttribute> getUniManyToOne();

	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaAttribute> getUniManyToMany();
	
	/**
	 * 
	 * @return
	 */
	public TCollection<TMJpaAttribute> getJpaAttributes();
}
