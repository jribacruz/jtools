package jtools.commons.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface TGeneratorXMLUpdater {

	public void update();

	public JavaClassSource inSource();
}
