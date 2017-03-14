package br.com.mais.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore // Não rodará o salvar quando for necessário
	public void Salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.Salvar(estado);
	}

	@Test
	@Ignore
	public void Listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.Listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);

		if (estado != null) {
			System.out.println("Registro encontrado: ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		} else {
			System.out.println("Registro não encontrado.");
		}
	}

	@Test
    @Ignore
	public void Excluir() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		if (estado != null) {
			estadoDAO.Excluir(estado);
			System.out.println("Registro removido: ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		} else {
			System.out.println("Registro não encontrado");
		}
	}

	@Ignore
	@Test
	public void Editar() {
		Long codigo = 10L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigo);
		if (estado != null) {
			System.out.println("Registro a editar: ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Manaus");
			estado.setSigla("AM");
			estadoDAO.Editar(estado);
			
			System.out.println("Registro editado: ");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		} else {
			System.out.println("Registro não encontrado");
		}
	}
}
