package br.com.mais.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") //Esconder os warnings da classe
@MappedSuperclass //Anotação para dizer que a classe não correponde a uma tabela mas será usado por outros para gerar tabelas. Somente as filhas geram tabelas e o pai nunca.

//Classe de apoio para gerar a chave primária de outras tabelas. Não é uma tabela
public class GenericDomain implements Serializable {
	@Id //Serve para dizer para o código que ele e uma chave primária.
	@GeneratedValue(strategy = GenerationType.AUTO) //Gera o auto incremento da chave primária
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
