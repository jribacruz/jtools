package jtools.eclipse.core.internal.model.function;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.common.base.Function;
import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaSource;

import jtools.eclipse.core.internal.model.JxJavaClassImpl;
import jtools.eclipse.core.model.JxFile;
import jtools.eclipse.core.model.JxJavaClass;

public class FunctionJxFileToJxClass implements Function<JxFile, JxJavaClass> {

	@Override
	public JxJavaClass apply(JxFile arg0) {
		try {
			JavaDocBuilder builder = new JavaDocBuilder();
			JavaSource source = builder.addSource(arg0.getFile());
			return new JxJavaClassImpl(source.getClasses()[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
