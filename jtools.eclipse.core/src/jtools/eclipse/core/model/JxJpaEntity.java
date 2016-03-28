package jtools.eclipse.core.model;

import jtools.eclipse.core.JxCollection;

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
	public JxCollection<JxJpaAttribute> getUniOneToMany();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJpaAttribute> getUniOneToOne();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJpaAttribute> getUniManyToOne();

	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJpaAttribute> getUniManyToMany();
	
	/**
	 * 
	 * @return
	 */
	public JxCollection<JxJpaAttribute> getJpaAttributes();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public JxJpaAttribute getJpaAttributeByName(String name);

}
