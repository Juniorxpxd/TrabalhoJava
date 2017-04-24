package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Conta;

public class ContaDAO {
	private static ArrayList<Conta> contas = new ArrayList<Conta>();
	public static void adicionarConta(Conta c){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerConta(Conta c){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println();
			}
	}
	public static List<Conta> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Conta c");
		List<Conta> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarConta(Conta c){
		for (int i = 0; i < contas.size(); i++) {
			if(contas.get(i).getIdConta() == c.getIdConta()){
				contas.set(i, c);
			}
		}
	}
	public static Conta buscarContasPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Conta.class, id);
	}
}
