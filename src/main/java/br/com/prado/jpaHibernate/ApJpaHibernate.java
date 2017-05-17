package br.com.prado.jpaHibernate;

import br.com.prado.jpaHibernate.dao.PessoaDao;
import br.com.prado.jpaHibernate.entity.Pessoa;

public class ApJpaHibernate {

	public static void main(String[] args) {
		
		//insertPessoa();
		findPessoaPorId();

	}

	private static void findPessoaPorId() {
		Pessoa p1 = new PessoaDao().findBydId(1L);
		
		System.out.println(p1.toString());
		
		Pessoa p2 = new PessoaDao().findBydId(3L);
		
		System.out.println(p2.toString());
		
	}

	private static void insertPessoa() {
		Pessoa p1 = new Pessoa();
		
		p1.setPrimeiroNome("Ana Maria");
		p1.setSobreNome("Rosário");
		p1.setIdade(32);
		
		new PessoaDao().save(p1);		
		System.out.println(p1.toString());

		Pessoa p2 = new Pessoa();		
		p2.setPrimeiroNome("José Fernando");
		p2.setSobreNome("Prado");
		p2.setIdade(58);
		
        new PessoaDao().save(p2);		
		System.out.println(p2.toString());
		
		Pessoa p3 = new Pessoa();		
		p3.setPrimeiroNome("Fernando");
		p3.setSobreNome("Prado da cruz");
		p3.setIdade(37);
		
        new PessoaDao().save(p3);		
		System.out.println(p3.toString());
		
	}

}
