package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Agencia;

public class AgenciaDAO {
	private static ArrayList<Agencia> agencias = new ArrayList<Agencia>();
	public static void adicionarAgencia(Agencia a){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerAgencia(Agencia a){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
	}
	public static List<Agencia> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT a FROM Agencia a");
		List<Agencia> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarAgencia(Agencia a){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Agencia agencia = em.find(Agencia.class, a.getIdAgen());
		agencia.setNome(a.getNome());
		agencia.setAgencia(a.getAgencia());
		em.merge(agencia);
		em.getTransaction().commit();
		em.close();
	}
	public static Agencia buscarAgenciaPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Agencia.class, id);
	}
}
