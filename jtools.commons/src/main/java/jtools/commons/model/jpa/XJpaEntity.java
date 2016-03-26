package jtools.commons.model.jpa;

import jtools.commons.model.XClass;
import jtools.commons.types.XCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface XJpaEntity extends XClass {

	/**
	 * Retorna o atributo Id
	 * 
	 * @return
	 */
	public XJpaAttribute getId();
	
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
	public XCollection<XJpaAttribute> getUniOneToMany();

	/**
	 * 
	 * @return
	 */
	public XCollection<XJpaAttribute> getUniOneToOne();

	/**
	 * 
	 * @return
	 */
	public XCollection<XJpaAttribute> getUniManyToOne();

	/**
	 * 
	 * @return
	 */
	public XCollection<XJpaAttribute> getUniManyToMany();
	
	/**
	 * 
	 * @return
	 */
	public XCollection<XJpaAttribute> getJpaAttributes();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public XJpaAttribute getJpaAttributeByName(String name);

}
