package br.com.mais.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.mais.drograria.util.HibernateUtil;

public class HibernateUtilTest {
		@Test
		public void conectar(){
			//Inicia chamada do método getFabricaDeSessoes()
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			//Encerra chamada
			sessao.close();
			//Finaliza método
			HibernateUtil.getFabricaDeSessoes().close();
		}
}
