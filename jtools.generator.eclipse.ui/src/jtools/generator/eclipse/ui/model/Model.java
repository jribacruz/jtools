package jtools.generator.eclipse.ui.model;

import java.io.Serializable;
import java.util.List;

public interface Model extends Serializable {

	public String getPackageName();

	public String getName();
	
	public List<Relationship> getRelationships();
	
	public List<Attribute> getAttributes();

}
