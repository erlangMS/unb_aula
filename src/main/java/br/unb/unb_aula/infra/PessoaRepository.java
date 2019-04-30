package br.unb.unb_aula.infra;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.erlangms.rest.RestApiDataFormat;
import br.erlangms.rest.request.IRestApiRequest;
import br.erlangms.rest.request.RestApiRequest;
import br.unb.unb_aula.model.Pessoa;

@Stateless
public class PessoaRepository extends EmsRepository<Pessoa> {

	private static final long serialVersionUID = -436214413480165780L;
	@PersistenceContext(unitName = "service_context")
	public EntityManager serviceContext;
	
	@EJB
	UnbAulaRestApiManager apiManager;

	@Override
	public EntityManager getEntityManager() {
		return serviceContext;
	}

	@Override
	public Class<Pessoa> getClassOfModel() {
		return Pessoa.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> find(String filter, String fields, int limit, int offset, String sort) {
		List<Pessoa> result = null;
		
		IRestApiRequest req = new RestApiRequest();
		req.setFilter(filter);
		req.setFields(fields);
		req.setLimit(limit);
		req.setOffset(offset);
		//req.setDataFormat(RestApiDataFormat.ENTITY);

		//result = super.find(filter, fields, limit, offset, sort);
		
		result = (List<Pessoa>) apiManager.find(req, PessoaRestProvider.class);
		return result;
	}

	
}
