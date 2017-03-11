package br.com.mais.drogaria.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.mais.drograria.util.HibernateUtil;

public class GenericDAO <Entidade> {
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}
	
	public void	Salvar(Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // iniciando a sessão
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // transaçao inicia o salvar
			sessao.save(entidade);
			transacao.commit(); //transaçao finaliza o salvar
		} catch (RuntimeException erro) {
			if(transacao != null){
				transacao.rollback();				
			}
			throw erro;
		} finally{
			sessao.close();			
		}
	}
	
	public List<Entidade> Listar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		 try {
			 		// Create CriteriaBuilder
			        CriteriaBuilder builder = sessao.getCriteriaBuilder();
			        
			        // Create CriteriaQuery
			         CriteriaQuery<Entidade> consulta = builder.createQuery(classe);
			 
			        // Specify criteria root
			        consulta.from(classe);
			 
			        // Execute query
			        List<Entidade> resultado = sessao.createQuery(consulta).getResultList();
			 
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally{
			sessao.close();			
		}
	}
	
	public Entidade Buscar(Long codigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Entidade resultado = null;
		try {		        
			resultado = sessao.find(classe, codigo);
		        return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally{
			sessao.close();			
		}
	}
	
	public void	Excluir (Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // iniciando a sessão
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // transaçao inicia o salvar
			sessao.delete(entidade);
			transacao.commit(); //transaçao finaliza o salvar
		} catch (RuntimeException erro) {
			if(transacao != null){
				transacao.rollback();				
			}
			throw erro;
		} finally{
			sessao.close();			
		}
	}	
	
	public void	Editar (Entidade entidade){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); // iniciando a sessão
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // transaçao inicia o salvar
			sessao.update(entidade);
			transacao.commit(); //transaçao finaliza o salvar
		} catch (RuntimeException erro) {
			if(transacao != null){
				transacao.rollback();				
			}
			throw erro;
		} finally{
			sessao.close();			
		}
	}	
	
}
