package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		agencias.remove(a);
	}
	public static List<Agencia> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT a FROM Cadastro.Agencia a");
		List<Agencia> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarAgencia(Agencia a){
		for (int i = 0; i < agencias.size(); i++) {
			if(agencias.get(i).getIdAgen() == a.getIdAgen()){
				agencias.set(i, a);
			}
		}
	}
}
