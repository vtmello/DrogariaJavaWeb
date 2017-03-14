package br.com.mais.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mais.drogaria.domain.Cidade;
import br.com.mais.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void Salvar() {
		Long codigoEstado = 3L;
		// Em caso de chave estrangeira, sempre pesquisar pelos pais antes de
		// realizar a execução da filha		
		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.Buscar(codigoEstado);

		if (estado != null) {
			Cidade cidade = new Cidade();
			cidade.setNome("'Florianópolis");
			cidade.setEstado(estado);
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.Salvar(cidade);
			System.out.println("Registro salvo: ");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().toString());
		} else {
			System.out.println("Estado não encontrado. Cidade não criada.");
		}
	}

	@Test
	@Ignore
	public void Listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.Listar();

		for (Cidade cidade : resultado) {

			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void Buscar() {
		Long codigo = 5L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigo);

		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println();

	}

	@Test
	@Ignore
	public void Excluir() {
		Long codigo = 8L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigo);
		if (cidade != null) {
			cidadeDAO.Excluir(cidade);

			System.out.println("Cidade Removida: ");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		} else{
			System.out.println("Registro não encontrado.");
		}
	}
	
	@Ignore
	@Test
	public void Editar(){
		Long codigoCidade = 7L;
		Long codigoEstado = 9L;
		
		//Para alterar o código do estado na Cidade
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.Buscar(codigoEstado);
		
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.Buscar(codigoCidade);
		
		System.out.println("Cidade a ser editada: ");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println();
		
		cidade.setNome("Bahia");
		//Altera código 
		cidade.setEstado(estado);
		cidadeDAO.Editar(cidade);
		
		System.out.println("Cidade editada: ");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		
	}
}
