package br.unb.unb_aula.infra;

import br.erlangms.rest.contract.IRestApiContract;
import br.erlangms.rest.contract.RestApiContract;
import br.erlangms.rest.provider.RestApiEntityProvider;
import br.erlangms.rest.schema.IRestApiSchema;
import br.unb.unb_aula.model.Pessoa;

public class PessoaRestProvider extends RestApiEntityProvider {

	private static final long serialVersionUID = -4574257848328266133L;

	public PessoaRestProvider() {
		super();
		setEntityClass(Pessoa.class);
	}



	@Override
	public IRestApiContract createContract() {
		RestApiContract contract = new RestApiContract(this);
		IRestApiSchema schema = contract.getSchema();
		schema.addFieldAsInteger("id", "id");
		schema.addFieldAString("denominacao", "denominacao", 100);
		return contract;
	}

}
