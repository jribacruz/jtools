package jtools.commons.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jtools.commons.internal.model.jpa.MJpaAttributeImpl;
import jtools.commons.internal.model.jpa.MJpaEntityImpl;
import jtools.commons.model.jpa.XJpaAttribute;
import jtools.commons.model.jpa.XJpaEntity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MJpaEntityTest {

	@Test
	public void getColumnName_Test() throws FileNotFoundException, IOException {
		XJpaEntity jpaEntity = new MJpaEntityImpl(new File("src/test/java/jtools/commons/fixture/model/XyzEntity.java"));
		
		XJpaAttribute jpaAttribute = new MJpaAttributeImpl(jpaEntity.getAttributeByName("attr1").getJavaField());
		
		String columnName = (String) jpaAttribute.getColumnName();
		
		Assert.assertEquals(columnName, "ATTR_1");
	}
}
