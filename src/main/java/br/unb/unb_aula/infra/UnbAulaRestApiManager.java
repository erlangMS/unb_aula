package br.unb.unb_aula.infra;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.rest.RestApiJpaManager;

@Singleton
public class UnbAulaRestApiManager extends RestApiJpaManager {

	@PersistenceContext(unitName = "service_context")
	public EntityManager serviceContext;
	
	private static final long serialVersionUID = 3765118336604889244L;
	
	@PostConstruct
	public void initialize() {
		setEntityManager(serviceContext);
	}
	

}
