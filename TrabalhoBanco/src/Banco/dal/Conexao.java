package Banco.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabalhoBanco");
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}