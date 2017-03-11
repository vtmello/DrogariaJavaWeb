package br.com.mais.drograria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	//Fabrica de sessões recebe o resultado do método criarFabricaDeSessoes();
	private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
	
	//Quando o usuário quiser usar a fábrica de sessões usará o método getFabricaDeSessoes();
	public static SessionFactory getFabricaDeSessoes() {
		return fabricaDeSessoes;
	}
	
	private static SessionFactory criarFabricaDeSessoes(){		
		try {
			//Lê as configurações do hibernate.cfg.xml
			Configuration configuracao = new Configuration().configure();
			//Registrar o serviço
			@SuppressWarnings("unused")
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			//Constrói a fábrica de sessões
			SessionFactory fabrica = configuracao.buildSessionFactory();
			// return o resultado para a variável fabricaDeSessoes
			return fabrica;
		} catch (Throwable ex) {
			// Não esquecer o throw
			System.err.println("A criação da fábrica de sessões falhou" + ex);
			throw new ExceptionInInitializerError(ex);		
		}
	}
	
}
