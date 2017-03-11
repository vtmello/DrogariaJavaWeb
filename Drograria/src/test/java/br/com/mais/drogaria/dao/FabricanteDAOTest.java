package br.com.mais.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void Salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Aché");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.Salvar(fabricante);
	}
	@Test	
	public void Listar() {
		FabricanteDAO FabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = FabricanteDAO.Listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);

		if (fabricante != null) {
			System.out.println("Registro encontrado: ");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		} else {
			System.out.println("Registro não encontrado.");
		}
	}
	
	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);
		if(fabricante != null){
		fabricanteDAO.Excluir(fabricante);
		System.out.println("Registro removido: ");
		System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());	
		} else {
			System.out.println("Registro não encontrado");		
		}
	}
	
	@Test
	public void Editar() {
		Long codigo = 10L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.Buscar(codigo);
		if (fabricante != null) {
			System.out.println("Registro a editar: ");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
			
			fabricante.setDescricao("Rivotril");
			fabricanteDAO.Editar(fabricante);
			
			System.out.println("Registro editado: ");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		} else {
			System.out.println("Registro não encontrado");
		}
	}
	
}
