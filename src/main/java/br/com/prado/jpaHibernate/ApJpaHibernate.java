package br.com.prado.jpaHibernate;


import java.util.Arrays;
import java.util.List;

import br.com.prado.jpaHibernate.dao.DocumentoDao;
import br.com.prado.jpaHibernate.dao.EnderecoDao;
import br.com.prado.jpaHibernate.dao.PessoaDao;
import br.com.prado.jpaHibernate.dao.TelefoneDao;
import br.com.prado.jpaHibernate.entity.Documento;
import br.com.prado.jpaHibernate.entity.Endereco;
import br.com.prado.jpaHibernate.entity.Endereco.TipoEndereco;
import br.com.prado.jpaHibernate.entity.Pessoa;
import br.com.prado.jpaHibernate.entity.Telefone;
import br.com.prado.jpaHibernate.entity.Telefone.TipoTelefone;

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
		//buscaPorCpf();	
		
		//insertTelefone();
		//insertTelefonePorPessoa();
		//updateTelefone();
		//updateTelefonePorPessoa();
		//deleteEmCascade();
		
		//insertEnderecoPorPessoa();
		//insertPessoaPorEndereco();
		enderecoPorCidade();
		
		
		

	}
	
	private static void enderecoPorCidade() {
		List<Endereco> enderecos = new EnderecoDao().buscarPorCidade("Florianopolis");
		 for(Endereco endereco : enderecos){
			 System.out.println(endereco.toString());
		 }
		
	}

	private static void insertPessoaPorEndereco() {
		Pessoa pessoa = new PessoaDao().findBydId(2L);
Endereco ad1 = new Endereco();
		
		ad1.setCidade("Urupema");
		ad1.setLogradouro("Av. Das flores n20");
		ad1.setTipoEndereco(TipoEndereco.RESIDENCIAL);
		ad1.setPessoa(Arrays.asList(pessoa));
		
		EnderecoDao dao = new EnderecoDao();
		dao.save(ad1);
		System.out.println(dao.findBydId(ad1.getId()));
	}

	private static void insertEnderecoPorPessoa() {
		Endereco ad1 = new Endereco();
		
		ad1.setCidade("Urupema");
		ad1.setLogradouro("Av. Mauro n20");
		ad1.setTipoEndereco(TipoEndereco.RESIDENCIAL);
		
		Endereco ad2 = new Endereco();
		
		ad2.setCidade("Florianopolis");
		ad2.setLogradouro("Av. Luz n10");
		ad2.setTipoEndereco(TipoEndereco.COMERCIAL);
		
		Pessoa p1 = new Pessoa();
		p1.setPrimeiroNome("João Pedro");
		p1.setSobreNome("Perira");
		p1.setIdade(25);		
		p1.setDocumento(new Documento("055.555.666.22", 23654879));		
		p1.addTelefone(new Telefone(TipoTelefone.RESIDENCIAL, "4524843154"));
		p1.addTelefone(new Telefone(TipoTelefone.COMERCIAL, "2155454654"));
		
		p1.setEnderecos(Arrays.asList(ad1, ad2));
		
		new PessoaDao().save(p1);
		
		System.out.println(new PessoaDao().findBydId(p1.getId()));
		
		
	}


	//**Telfone**//
	private static void deleteEmCascade() {
		//new PessoaDao().delete(7L);
		//new TelefoneDao().delete(6L);
		
		TelefoneDao tele = new TelefoneDao();
		Telefone telefone = tele.findBydId(6L);
		
		System.out.println(telefone);
		
		telefone.getPessoa().delTelefone(telefone);
		
		tele.delete(telefone);
		
	}


	private static void updateTelefonePorPessoa() {
		Pessoa pessoa = new PessoaDao().findBydId(7L);
		
		for(Telefone phone : pessoa.getTelefones()){
			System.out.println("1- " + phone.toString());
			
				if(TipoTelefone.RESIDENCIAL == phone.getTipo()){
					phone.setTipo(TipoTelefone.COMERCIAL);
				}
		}
		new PessoaDao().update(pessoa);
		
	}


	private static void updateTelefone() {
		Pessoa pessoa = new PessoaDao().findBydId(1L);
		
		TelefoneDao dao = new TelefoneDao();
		
		Telefone t2 = dao.findBydId(6L);
		t2.setPessoa(pessoa);
		
		dao.update(t2);
		
	}


	private static void insertTelefonePorPessoa() {
		
		Telefone t1 = new Telefone(TipoTelefone.CELULAR, "9254686541");
		Telefone t2 = new Telefone(TipoTelefone.COMERCIAL, "214562453");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setPrimeiroNome("Joaquina");
		pessoa.setSobreNome("Lilica");
		pessoa.setIdade(65);
			
		pessoa.setDocumento(new Documento("444.444.555-44", 1524455678));
		
		pessoa.addTelefone(t1);
		pessoa.addTelefone(t2);
		new PessoaDao().save(pessoa);
	}


	private static void insertTelefone() {
		Pessoa pessoa = new Pessoa();
		pessoa.setPrimeiroNome("Elena");
		pessoa.setSobreNome("borges");
		pessoa.setIdade(45);
		
		pessoa.setDocumento(new Documento("444.444.444-44", 1524245678));
		
		Telefone telefone = new Telefone(TipoTelefone.CELULAR, "91225808");
		telefone.setPessoa(pessoa);
		
		TelefoneDao dao = new TelefoneDao();
		
		dao.save(telefone);
		dao.findBydId(telefone.getId());
		
		
		System.out.println(telefone.toString());
		
	}
	
	
	//**Documento**//

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
