package br.com.mais.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Cliente;
import br.com.mais.drogaria.domain.Pessoa;

public class ClienteDAOTest {

	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void Salvar() {
		Long codigoCliente = 11L;
		// Em caso de chave estrangeira, sempre pesquisar pelos pais antes de
		// realizar a execução da filha
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoCliente);

		Cliente cliente = new Cliente();

		if (cliente != null) {
			cliente.setDataCadastro(new Date());
			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.Salvar(cliente);

			System.out.println("Cliente salvo com suceso.");
		} else
			System.out.println("Pessoa não encontrada.");
	}

	@Test
	@Ignore
	public void Listar() {

		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.Listar();

		for (Cliente cliente : resultado) {
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Data do Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigoCliente = 11L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigoCliente);

		System.out.println("Código: " + cliente.getCodigo());
		System.out.println("Nome: " + cliente.getPessoa().getNome());
		System.out.println("CPF: " + cliente.getPessoa().getCpf());
		System.out.println("Data do Cadastro: " + cliente.getDataCadastro());
		System.out.println("Liberado: " + cliente.getLiberado());

	}
	@Test
	@Ignore
	public void Excluir() {
		Long codigoCliente = 11L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigoCliente);

		if (cliente != null) {
			clienteDAO.Excluir(cliente);

			System.out.println("Cidade Removida: ");
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Data do Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
		} else {
			System.out.println("Registro não encontrado.");
		}
	}
	
	@Test
	public void Editar(){
		Long codigoCliente = 12L;
		Long codigoPessoa = 11L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoPessoa);
		
		System.out.println("Cadastro completo Cliente: ");
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
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.Buscar(codigoCliente);
		
		System.out.println("Cliente a ser editado: ");
		System.out.println("Código da Cidade: " + cliente.getCodigo());
		System.out.println("Nome da Cidade: " + cliente.getLiberado());
		System.out.println("Código do Estado: " + cliente.getPessoa().getNome());
		System.out.println("Sigla do Estado: " + cliente.getPessoa().getCpf());
		System.out.println("Nome do Estado: " + cliente.getPessoa().getEmail());
		System.out.println();
		
		cliente.setLiberado(false);
		clienteDAO.Editar(cliente);
		
		System.out.println("Cliente editado: ");
		System.out.println("Código da Cidade: " + cliente.getCodigo());
		System.out.println("Nome da Cidade: " + cliente.getLiberado());
		System.out.println("Código do Estado: " + cliente.getPessoa().getNome());
		System.out.println("Sigla do Estado: " + cliente.getPessoa().getCpf());
		System.out.println("Nome do Estado: " + cliente.getPessoa().getEmail());
		System.out.println();
		
	}
}
