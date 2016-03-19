package jtools.commons.internal.model;

import java.util.Set;

import com.thoughtworks.qdox.model.JavaField;

import jtools.commons.model.TMJpaAttribute;

public class TMJpaAttributeImpl extends TMClassAttributeImpl implements TMJpaAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TMJpaAttributeImpl(JavaField javaField) {
		super(javaField);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isId()
	 */
	@Override
	public boolean isId() {
		return hasAnnotation("Id");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isTransient()
	 */
	@Override
	public boolean isTransient() {
		return hasAnnotation("Transient");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isLob()
	 */
	@Override
	public boolean isLob() {
		return hasAnnotation("Lob");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnName()
	 */
	@Override
	public String getColumnName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnLength()
	 */
	@Override
	public int getColumnLength() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnUpdatable()
	 */
	@Override
	public boolean isColumnUpdatable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnInsertable()
	 */
	@Override
	public boolean isColumnInsertable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnNullable()
	 */
	@Override
	public boolean isColumnNullable() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnPrecision()
	 */
	@Override
	public int getColumnPrecision() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnScale()
	 */
	@Override
	public int getColumnScale() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnTable()
	 */
	@Override
	public String getColumnTable() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnUnique()
	 */
	@Override
	public boolean isColumnUnique() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getJoinColumnName()
	 */
	@Override
	public String getJoinColumnName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.TMJpaAttribute#getJoinColumnReferencedColumnName()
	 */
	@Override
	public String getJoinColumnReferencedColumnName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getJoinTableName()
	 */
	@Override
	public String getJoinTableName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getJoinTableJoinColumnName()
	 */
	@Override
	public String getJoinTableJoinColumnName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jtools.commons.model.TMJpaAttribute#getJoinTableInverseJoinColumnName()
	 */
	@Override
	public String getJoinTableInverseJoinColumnName() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getJoinTableSchema()
	 */
	@Override
	public String getJoinTableSchema() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToManyMappedBy()
	 */
	@Override
	public String getOneToManyMappedBy() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isOneToMany()
	 */
	@Override
	public boolean isOneToMany() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToManyCascadeType()
	 */
	@Override
	public Set<String> getOneToManyCascadeType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isOneToManyOrphanRemoval()
	 */
	@Override
	public boolean isOneToManyOrphanRemoval() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToManyFetchType()
	 */
	@Override
	public String getOneToManyFetchType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isManyToOneOptional()
	 */
	@Override
	public boolean isManyToOneOptional() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isManyToOne()
	 */
	@Override
	public boolean isManyToOne() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getManyToOneFetchType()
	 */
	@Override
	public String getManyToOneFetchType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isOneToOne()
	 */
	@Override
	public boolean isOneToOne() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToOneMappedBy()
	 */
	@Override
	public String getOneToOneMappedBy() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToOneCascadeType()
	 */
	@Override
	public Set<String> getOneToOneCascadeType() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToOneOrphanRemoval()
	 */
	@Override
	public boolean getOneToOneOrphanRemoval() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isManyToMany()
	 */
	@Override
	public boolean isManyToMany() {
		return hasAnnotation("ManyToMany");
	}

}
