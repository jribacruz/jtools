package jtools.eclipse.demoiselle.test.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import jtools.eclipse.demoiselle.test.domain.Foo;
import jtools.eclipse.demoiselle.test.persistence.FooDAO;

@BusinessController
public class FooBC extends DelegateCrud<Foo, Long, FooDAO> {
	
	private static final long serialVersionUID = 1L;
	
	
}
