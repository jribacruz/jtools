package jtools.commons.model.jpa;

import jtools.commons.model.MClass;
import jtools.commons.types.TCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface MJpaEntity extends MClass {

	/**
	 * Retorna o atributo Id
	 * 
	 * @return
	 */
	public MJpaAttribute getId();
	
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
	public TCollection<MJpaAttribute> getUniOneToMany();

	/**
	 * 
	 * @return
	 */
	public TCollection<MJpaAttribute> getUniOneToOne();

	/**
	 * 
	 * @return
	 */
	public TCollection<MJpaAttribute> getUniManyToOne();

	/**
	 * 
	 * @return
	 */
	public TCollection<MJpaAttribute> getUniManyToMany();
	
	/**
	 * 
	 * @return
	 */
	public TCollection<MJpaAttribute> getJpaAttributes();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public MJpaAttribute getJpaAttributeByName(String name);

}
