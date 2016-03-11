package jtools.commons.internal.generator;

import java.io.File;
import java.io.FileNotFoundException;

import jtools.commons.generator.TGeneratorJavaUpdater;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class TGeneratorJavaUpdaterImpl implements TGeneratorJavaUpdater {

	private JavaClassSource source;

	private File javaClassFile;

	public TGeneratorJavaUpdaterImpl(File javaClassFile) throws FileNotFoundException {
		super();
		this.source = Roaster.parse(JavaClassSource.class, javaClassFile);
		this.javaClassFile = javaClassFile;
	}

	@Override
	public void update() {

	}

	@Override
	public JavaClassSource inClass() {
		return this.source;
	}

}
