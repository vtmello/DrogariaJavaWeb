package br.com.mais.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain {
	@Column(length = 25, nullable = false)
	private String nome;
	
	@ManyToOne //Definindo a chave estrangeira com o relacionamento
	@JoinColumn(nullable = false) //Personaliza característcas de uma chave estrageira
	private Estado estado;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


}
