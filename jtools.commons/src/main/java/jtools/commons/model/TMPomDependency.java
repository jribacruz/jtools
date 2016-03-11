package jtools.commons.model;

import java.io.Serializable;

public interface TMPomDependency extends Serializable {

	public String getGroupId();

	public String getArtifactId();

	public String getVersion();

	public String getScope();
}
