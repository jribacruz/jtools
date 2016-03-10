package jtools.commons.internal.generator;

import java.io.File;
import java.io.FileNotFoundException;

import jtools.commons.generator.TGeneratorJavaUpdater;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class TGeneratorJavaUpdaterImpl implements TGeneratorJavaUpdater {

	private JavaClassSource source;

	public TGeneratorJavaUpdaterImpl(File javaClassFile) throws FileNotFoundException {
		super();
		this.source = Roaster.parse(JavaClassSource.class, javaClassFile);
	}

	@Override
	public void update() {

	}

}
