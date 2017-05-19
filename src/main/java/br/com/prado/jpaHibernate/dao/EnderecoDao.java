package br.com.prado.jpaHibernate.dao;

import java.util.List;

import br.com.prado.jpaHibernate.entity.Endereco;

public class EnderecoDao extends GenericDao<Endereco> {

	public EnderecoDao() {
		super(Endereco.class);
	}
	
	public List<Endereco> buscarPorCidade(String cidade){
		String jpql = "from Endereco a where a.cidade like ?";
		
		return Find(jpql, cidade);
	}

}
