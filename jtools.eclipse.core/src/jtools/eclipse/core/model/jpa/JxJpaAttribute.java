package jtools.eclipse.core.model.jpa;

import java.util.Set;

import jtools.eclipse.core.model.JxClassAttribute;

public interface JxJpaAttribute extends JxClassAttribute {

	/**
	 * 
	 * Verifica se o atributo é o ID da entidade.
	 * 
	 * @return
	 */
	public boolean isId();

	/**
	 * 
	 * Verifica se o atributo e transiente.
	 * 
	 * @return
	 */
	public boolean isTransient();

	/**
	 * 
	 * Verifica se o atributo e Lob.
	 * 
	 * @return
	 */
	public boolean isLob();

	/**
	 * 
	 * Retorna o valor do atributo name da annotation @Column.
	 * 
	 * @return
	 */
	public String getColumnName();

	/**
	 * 
	 * Retorna a valor do atributo length da annotation @Column.
	 * 
	 * @return
	 */
	public int getColumnLength();

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean isColumnUpdatable();

	/**
	 * 
	 * @return
	 */
	public boolean isColumnInsertable();

	/**
	 * 
	 * @return
	 */
	public boolean isColumnNullable();

	/**
	 * 
	 * @return
	 */
	public int getColumnPrecision();

	/**
	 * 
	 * @return
	 */
	public int getColumnScale();

	/**
	 * 
	 * @return
	 */
	public String getColumnTable();

	/**
	 * 
	 * @return
	 */
	public boolean isColumnUnique();

	/**
	 * 
	 * @return
	 */
	public String getJoinColumnName();

	/**
	 * 
	 * @return
	 */
	public String getJoinColumnReferencedColumnName();

	/**
	 * 
	 * @return
	 */
	public String getJoinTableName();

	/**
	 * 
	 * @return
	 */
	public String getJoinTableJoinColumnName();

	/**
	 * 
	 * @return
	 */
	public String getJoinTableInverseJoinColumnName();

	/**
	 * 
	 * @return
	 */
	public String getJoinTableSchema();

	/**
	 * 
	 * @return
	 */
	public String getOneToManyMappedBy();

	/**
	 * 
	 * @return
	 */
	public boolean isOneToMany();

	/**
	 * 
	 * @return
	 */
	public Set<String> getOneToManyCascadeType();

	/**
	 * 
	 * @return
	 */
	public boolean isOneToManyOrphanRemoval();

	/**
	 * 
	 * @return
	 */
	public String getOneToManyFetchType();

	/**
	 * 
	 * @return
	 */
	public boolean isManyToOneOptional();

	/**
	 * 
	 * @return
	 */
	public boolean isManyToOne();

	/**
	 * 
	 * @return
	 */
	public String getManyToOneFetchType();

	/**
	 * 
	 * @return
	 */
	public boolean isOneToOne();

	/**
	 * 
	 * @return
	 */
	public String getOneToOneMappedBy();

	/**
	 * 
	 * @return
	 */
	public Set<String> getOneToOneCascadeType();

	/**
	 * 
	 * @return
	 */
	public boolean getOneToOneOrphanRemoval();

	/**
	 * 
	 * @return
	 */
	public boolean isManyToMany();


}
