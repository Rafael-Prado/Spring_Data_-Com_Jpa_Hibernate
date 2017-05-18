package br.com.prado.jpaHibernate.dao;

import java.util.List;

import br.com.prado.jpaHibernate.entity.Pessoa;

public class PessoaDao extends GenericDao<Pessoa>{

	public PessoaDao() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa pessoaNomeCompleto(String nome, String sobreNome){
		
		String jpql = "from Pessoa p where p.primeiroNome like ? and p.sobreNome like ? ";
		return FindOne(jpql, nome, sobreNome);
	}
	
	public List<Pessoa> porIdade(int mim, int max){
		String jpql = "from Pessoa p where p.idade between ? and ?";
		
		return Find(jpql, mim, max);
	}
	
	public List<Pessoa> PessoaSobreNome(String sobreNome){
		String jpql = "from Pessoa p where p.sobreNome like ?";
		return Find(jpql, sobreNome);
	}
	
	public Pessoa pessoaPorCpf(String cpf){
		String jpql = "select p from Pessoa p, Documento d where d.cpf like ? " +
						"and p.documento.id = d.id";	
		
		return FindOne(jpql, cpf);
	}

}
