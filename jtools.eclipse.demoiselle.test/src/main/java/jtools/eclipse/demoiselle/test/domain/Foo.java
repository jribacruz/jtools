package jtools.eclipse.demoiselle.test.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foo {

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;
	
}
