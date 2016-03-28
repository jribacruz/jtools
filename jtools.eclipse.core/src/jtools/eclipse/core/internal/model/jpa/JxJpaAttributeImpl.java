package jtools.eclipse.core.internal.model.jpa;

import java.util.Set;

import jtools.eclipse.core.internal.model.JxClassAttributeImpl;
import jtools.eclipse.core.model.jpa.JxJpaAttribute;
import jtools.eclipse.core.util.Strings;

import com.thoughtworks.qdox.model.JavaField;

public class JxJpaAttributeImpl extends JxClassAttributeImpl implements JxJpaAttribute {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JxJpaAttributeImpl(JavaField javaField) {
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
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("Column", "name"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnLength()
	 */
	@Override
	public int getColumnLength() {
		return (int) getAnnotationNamedParameter("Column", "length");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnUpdatable()
	 */
	@Override
	public boolean isColumnUpdatable() {
		return (boolean) getAnnotationNamedParameter("Column", "updatable");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnInsertable()
	 */
	@Override
	public boolean isColumnInsertable() {
		return (boolean) getAnnotationNamedParameter("Column", "insertable");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isColumnNullable()
	 */
	@Override
	public boolean isColumnNullable() {
		return (boolean) getAnnotationNamedParameter("Column", "nullable");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnPrecision()
	 */
	@Override
	public int getColumnPrecision() {
		return (int) getAnnotationNamedParameter("Column", "precision");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getColumnScale()
	 */
	@Override
	public int getColumnScale() {
		return (int) getAnnotationNamedParameter("Column", "scale");
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
		return (boolean) getAnnotationNamedParameter("Column", "inique");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getJoinColumnName()
	 */
	@Override
	public String getJoinColumnName() {
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("JoinColumn", "name"));
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
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("JoinTable", "name"));
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
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("JoinTable", "schema"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToManyMappedBy()
	 */
	@Override
	public String getOneToManyMappedBy() {
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("OneToMany", "mappedBy"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isOneToMany()
	 */
	@Override
	public boolean isOneToMany() {
		return hasAnnotation("OneToMany");
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
		return (boolean) getAnnotationNamedParameter("OneToMany", "orphanRemoval");
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
		return (boolean) getAnnotationNamedParameter("ManyToOne", "optional");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#isManyToOne()
	 */
	@Override
	public boolean isManyToOne() {
		return hasAnnotation("ManyToOne");
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
		return hasAnnotation("OneToOne");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jtools.commons.model.TMJpaAttribute#getOneToOneMappedBy()
	 */
	@Override
	public String getOneToOneMappedBy() {
		return Strings.removeStartEndQuotes((String) getAnnotationNamedParameter("Column", "mappedBy"));
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
		return (boolean) getAnnotationNamedParameter("OneToOne", "orphanRemoval");
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