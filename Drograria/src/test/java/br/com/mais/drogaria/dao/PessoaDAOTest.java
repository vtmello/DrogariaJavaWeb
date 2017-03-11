package br.com.mais.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	@Ignore
	public void Salvar() {

		Pessoa pessoa = new Pessoa();

		pessoa.setBairro("Cruzeiro");
		pessoa.setCelular("3198771-8548");
		pessoa.setTelefone("3132877477");
		pessoa.setCep("30310-360");
		pessoa.setComplemento("101");
		pessoa.setCpf("074.669.066-25");
		pessoa.setEmail("vtmello.mf@gmail.com");
		pessoa.setNome("Vinícius Freitas");
		pessoa.setNumero((short) 222);
		pessoa.setRg("MG12458444");
		pessoa.setRua("Rua Vitorio Marcola");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.Salvar(pessoa);

	}

	@Test
	@Ignore
	public void Listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.Listar();

		for (Pessoa pessoa : resultado) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println();
		}
	}
	@Test
	@Ignore
	public void Buscar() {
		long codigoPessoa = 11L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);

		if (pessoa != null) {
			System.out.println("Registro encontrado: ");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println();
		} else {
			System.out.println("Registro não encontrado.");
		}
	}
	@Test
    @Ignore
	public void Excluir() {
		Long codigoPessoa = 12L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);
		if (pessoa != null) {
			System.out.println("Registro removido: ");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println();
			pessoaDAO.Excluir(pessoa);
		} else {
			System.out.println("Registro não encontrado");
		}
	}
	
	@Test
	public void Editar(){
		Long codigoPessoa = 11L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);
		
		if (pessoa != null) {
			System.out.println("Registro a editar: ");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println();
			
			pessoa.setNome("Vinícius Freitas");
			pessoaDAO.Editar(pessoa);
			
			System.out.println("Registro editado: ");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println();
		} else {
			System.out.println("Registro não encontrado");
		}
		
	}
}
