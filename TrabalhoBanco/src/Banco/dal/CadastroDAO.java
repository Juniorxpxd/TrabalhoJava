package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Banco.model.Cadastro;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public static void addCadastro(Cadastro c){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerCadastro(Cadastro c){
		cadastros.remove(c);
	}
	public static List<Cadastro> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT c FROM Cadastro c");
		List<Cadastro> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarCadastro(Cadastro c){
		for (int i = 0; i < cadastros.size(); i++) {
			if(cadastros.get(i).getIdCad() == c.getIdCad()){
				cadastros.set(i, c);
			}
		}
	}
}
