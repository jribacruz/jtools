package jtools.eclipse.core.model;

import jtools.eclipse.core.XCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface JxJpaEntity extends JxClass {

	/**
	 * Retorna o atributo Id
	 * 
	 * @return
	 */
	public JxJpaAttribute getId();
	
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
	public XCollection<JxJpaAttribute> getUniOneToMany();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxJpaAttribute> getUniOneToOne();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxJpaAttribute> getUniManyToOne();

	/**
	 * 
	 * @return
	 */
	public XCollection<JxJpaAttribute> getUniManyToMany();
	
	/**
	 * 
	 * @return
	 */
	public XCollection<JxJpaAttribute> getJpaAttributes();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public JxJpaAttribute getJpaAttributeByName(String name);

}
