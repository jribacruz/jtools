package jtools.eclipse.demoiselle.test.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import jtools.eclipse.demoiselle.test.domain.Foo;

@PersistenceController
public class FooDAO extends JPACrud<Foo, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
