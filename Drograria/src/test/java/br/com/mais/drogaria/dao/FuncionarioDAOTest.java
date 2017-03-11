package br.com.mais.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Funcionario;
import br.com.mais.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@SuppressWarnings("unused")
	@Test
	@Ignore

	public void Salvar() {

		Long codigoFuncionario = 11L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoFuncionario);

		Funcionario funcionario = new Funcionario();

		if (funcionario != null) {
			funcionario.setDataAdmissao(new Date());
			funcionario.setCarteiraTrabalho("CTPS");
			funcionario.setPessoa(pessoa);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.Salvar(funcionario);

			System.out.println("Funcionario salvo com suceso.");
		} else {
			System.out.println("Funcionario não encontrada.");
		}
	}
	
	@Test
	@Ignore
	public void Listar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.Listar();
		
		for (Funcionario funcionario : resultado) {
			System.out.println("Código: " + funcionario.getCodigo());
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa());
		}	
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigoFuncionario = 11L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigoFuncionario);
		
		System.out.println("Código: " + funcionario.getCodigo());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Pessoa: " + funcionario.getPessoa());
	}
	
	@Test
	@Ignore
	public void Excluir(){
		
		Long codigoFuncionario = 11L;
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigoFuncionario);
		
		if(funcionario != null){
			funcionarioDAO.Excluir(funcionario);
			
			System.out.println("Código: " + funcionario.getCodigo());
			System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
			System.out.println("Pessoa: " + funcionario.getPessoa());
			
			System.out.println("Funcionario excluído com sucesso.");
			
		} else{
			System.out.println("Funcionario não encontrado.");
		}
	}
	@Test
	@Ignore
	public void editar(){
		Long codigoPessoa = 11L;
		Long codigoFuncionario = 12L;
		
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
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.Buscar(codigoFuncionario);
		
		System.out.println("Cliente a ser editado: ");
		System.out.println("Código: " + funcionario.getCodigo());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Pessoa: " + funcionario.getPessoa());
		System.out.println();
		
		funcionario.setCarteiraTrabalho("CTPS/PIS");
		funcionarioDAO.Editar(funcionario);
		
		System.out.println("Cliente editado: ");
		System.out.println("Código: " + funcionario.getCodigo());
		System.out.println("Carteira de Trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data de Admissão: " + funcionario.getDataAdmissao());
		System.out.println("Código do Pessoa: " + funcionario.getPessoa().getNome());
		System.out.println("CPF: " + funcionario.getPessoa().getCpf());
		System.out.println("E-mail: " + funcionario.getPessoa().getEmail());
		System.out.println();
		
		
	}
}
