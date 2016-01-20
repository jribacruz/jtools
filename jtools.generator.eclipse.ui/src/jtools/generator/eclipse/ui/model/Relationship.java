package jtools.generator.eclipse.ui.model;

import java.io.Serializable;

public interface Relationship extends Serializable {

	public boolean isComposition();

	public boolean isOneToMany();

	public boolean isManyToOne();

	public boolean isManyToMany();

	public boolean isOneToOne();

}
