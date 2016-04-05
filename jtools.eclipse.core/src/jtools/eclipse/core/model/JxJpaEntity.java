package jtools.eclipse.core.model;

import jtools.eclipse.core.exception.JxElementNotFoundException;
import jtools.eclipse.core.util.JxCollection;

/**
 * 
 * @author jcruz
 *
 */
public interface JxJpaEntity extends JxJavaClass {

	/**
	 * Retorna o atributo Id
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxJpaAttribute getId() throws JxElementNotFoundException;

	/**
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public boolean isInheritance() throws JxElementNotFoundException;

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
	public JxCollection<JxJpaAttribute> findAllJpaAttributes();

	/**
	 * 
	 * @param name
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxJpaAttribute findJpaAttributeByName(String name) throws JxElementNotFoundException;

	/**
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxDemoisellePersistenceController findPersitenceController() throws JxElementNotFoundException;

	/**
	 * 
	 * @return
	 * @throws JxElementNotFoundException
	 */
	public JxDemoiselleBusinessController findBusinessController() throws JxElementNotFoundException;

	/**
	 * 
	 * @return
	 */
	public JxMavenProject getMavenProject();

}
