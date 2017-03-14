package br.com.mais.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.mais.drogaria.dao.EstadoDAO;
import br.com.mais.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean //Controle (Controller)
@ViewScoped
public class EstadoBean implements Serializable{
	
	EstadoDAO estadoDAO = new EstadoDAO();
	private Estado estado;
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct //Chama a pesquisa
	public void Listar(){
		try {
			estados = estadoDAO.Listar();
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("A T E N Ç Ã O!! Ocorreu um erro ao tentar listar os estados!");
			erro.printStackTrace();
		}
		
	}

	public void Novo(){
		estado = new Estado();		
	}
	
	public void Salvar(){
		try{
		estadoDAO.Salvar(estado);
		
		Novo();
		
		//Mensagem com OmniFaces - modo fácil
		Messages.addGlobalInfo("Estado salvo com sucesso!");
		}catch (RuntimeException erro) {
			Messages.addGlobalError("A T E N Ç Ã O!! Ocorreu um erro ao tentar listar os estados!");
			erro.printStackTrace();
		}
		/*MÉTODO JSF
		 * 
		 * String texto = "Programação Web com Java!!!";
		FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto); //Exibe mensagens de erro, informativo ou erro severo. (1º arg mensagem comum, 2º mensagem detalhada)
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, messagem);*/
	}
}
