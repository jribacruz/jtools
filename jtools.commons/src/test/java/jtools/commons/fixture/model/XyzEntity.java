package jtools.commons.fixture.model;

import jtools.commons.fixture.annotation.Column;
import jtools.commons.fixture.annotation.Entity;

@Entity
public class XyzEntity {

	@Column(name = "ATTR_1")
	private String attr1;

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

}
