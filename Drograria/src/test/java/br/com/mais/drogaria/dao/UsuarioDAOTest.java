package br.com.mais.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Pessoa;
import br.com.mais.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@SuppressWarnings("unused")
	@Test
	@Ignore
	
	public void Salvar() {
		Long codigoUsuario = 11L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(codigoUsuario);

		Usuario usuario = new Usuario();

		if (usuario != null) {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.Salvar(usuario);

			System.out.println("Usuario salvo com suceso.");
		} else {
			System.out.println("Usuario não encontrada.");
		}
	}

	@Test
	@Ignore
	public void Listar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.Listar();
		
		for(Usuario usuario : resultado){
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Senha: " + usuario.getSenha());
		}
	}
	
	@Test
	@Ignore
	public void Buscar(){
		Long codigoUsuario = 11L;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(codigoUsuario);
		
		System.out.println("Código: " + usuario.getCodigo());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Status: " + usuario.getAtivo());
		System.out.println("Senha: " + usuario.getSenha());
		
	}
	
	@Test
	@Ignore
	public void Excluir(){
		Long codigoUsuario = 11L;
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(codigoUsuario);
		
		if(usuario != null){
			
			System.out.println("Código: " + usuario.getCodigo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Senha: " + usuario.getSenha());
			
			System.out.println("Usuario excluído com sucesso.");
			
		} else{
			System.out.println("Usuario não encontrado.");
		}
	}

	@Test
	@Ignore
	public void editar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.Buscar(11L);
		
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
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(12L);
		
		System.out.println("Cliente a ser editado: ");
		System.out.println("Código: " + usuario.getCodigo());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Status: " + usuario.getAtivo());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println();
		
		usuario.setAtivo(false);
		usuarioDAO.Editar(usuario);
		
		System.out.println("Cliente editado: ");
		System.out.println("Código: " + usuario.getCodigo());
		System.out.println("Tipo: " + usuario.getTipo());
		System.out.println("Status: " + usuario.getAtivo());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println();
		
		
	}
	
}

