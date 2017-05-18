package br.com.prado.jpaHibernate;

import java.util.List;

import br.com.prado.jpaHibernate.dao.DocumentoDao;
import br.com.prado.jpaHibernate.dao.PessoaDao;
import br.com.prado.jpaHibernate.entity.Documento;
import br.com.prado.jpaHibernate.entity.Pessoa;

public class ApJpaHibernate {

	public static void main(String[] args) {
		
		//insertPessoa();
		//findPessoaPorId();
		//findAllPessoa();
		//countPessoas();
		//pessoaPorSobreNome();
		//pessoaPorIdade();
		//pessoaPorNome();
		//updatePessoa();
		//deletePessoa();
		
		
		//insertDocumento();
		//updateDocumento();
		buscaPorCpf();	
		

	}	
	
	private static void buscaPorCpf() {
		Pessoa p = new PessoaDao().pessoaPorCpf("049.584.199-42");
		
		System.out.println(p.toString());
	}

	private static void updateDocumento() {
		Documento doc  = new DocumentoDao().findBydId(1L);
		System.out.println(doc.toString());
		
		doc.setRg(321654987);		
		new DocumentoDao().update(doc);
		
		System.out.println(new DocumentoDao().findBydId(1L));
	}

	private static void insertDocumento() {
		Pessoa p1 = new Pessoa();
		p1.setPrimeiroNome("Rafael");
		p1.setSobreNome("Barbosa");
		p1.setIdade(23);
		
		p1.setDocumento(new Documento("049.584.199-42", 123456789));
		
		new PessoaDao().save(p1);
		
		System.out.println(p1.toString());
		
	}


	//*** Pessoa***///
	private static void deletePessoa() {
		new PessoaDao().delete(3l);		
	}

	private static void updatePessoa() {
		Pessoa p1 = new PessoaDao().findBydId(3L);
		System.out.println(p1.toString());
		
		p1.setSobreNome("de souza");
		new PessoaDao().update(p1);
		
		Pessoa p2 = new PessoaDao().findBydId(3L);
		System.out.println(p2.toString());
	}



	private static void pessoaPorNome() {
		Pessoa pessoa = new PessoaDao().pessoaNomeCompleto("José Fernando", "Prado");
		System.out.println(pessoa.toString());
	}



	private static void pessoaPorIdade() {
		
		List<Pessoa> pessoas = new PessoaDao().porIdade(31, 36);
		
		 for(Pessoa pessoa : pessoas){
			 System.out.println(pessoa.toString());
		 }
		
	}



	private static void pessoaPorSobreNome() {
		List<Pessoa> pessoas = new PessoaDao().PessoaSobreNome("Prado da cruz");
		
		 for(Pessoa pessoa : pessoas){
			 System.out.println(pessoa.toString());
		 }
		
	}



	private static void countPessoas() {
		Long total = new PessoaDao().count();
		System.out.println("Total de pessoas: " + total);
		
	}



	private static void findAllPessoa() {
		List<Pessoa> pessoas = new PessoaDao().findAll();
		for (Pessoa p : pessoas) {
			System.out.println(p.toString());
		}
		
	}



	private static void findPessoaPorId() {
		Pessoa p1 = new PessoaDao().findBydId(1L);
		
		System.out.println(p1.toString());
		
		Pessoa p2 = new PessoaDao().findBydId(3L);
		
		System.out.println(p2.toString());
		
	}

	private static void insertPessoa() {
		Pessoa p1 = new Pessoa();
		
		p1.setPrimeiroNome("Juca Maria");
		p1.setSobreNome("Rosário");
		p1.setIdade(32);
		
		new PessoaDao().save(p1);		
		System.out.println(p1.toString());

		Pessoa p2 = new Pessoa();		
		p2.setPrimeiroNome("Pedro Fernando");
		p2.setSobreNome("Prado");
		p2.setIdade(58);
		
        new PessoaDao().save(p2);		
		System.out.println(p2.toString());
		
		Pessoa p3 = new Pessoa();		
		p3.setPrimeiroNome("Fernanda");
		p3.setSobreNome("Prado da cruz");
		p3.setIdade(37);
		
        new PessoaDao().save(p3);		
		System.out.println(p3.toString());
		
	}

}
