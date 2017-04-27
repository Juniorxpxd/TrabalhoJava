package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Transferencia;

public class TransferenciaDAO {
	private static ArrayList<Transferencia> transferencias = new ArrayList<Transferencia>();
	public static void adicionarTransferencia(Transferencia t){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerTransferencia(Transferencia t){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			t = em.getReference(Transferencia.class, t.getIdTransferencia());
			em.remove(t);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
		}
	public static List<Transferencia> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query d = em.createQuery("SELECT t FROM Transferencia t");
		List<Transferencia> lista = d.getResultList();
		em.close();
		return lista;
	}
	public static void alterarTransferencia(Transferencia t){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Transferencia transferencia = em.find(Transferencia.class, t.getIdTransferencia());
		transferencia.setQuantidade(t.getQuantidade());
		em.merge(transferencia);
		em.getTransaction().commit();
		em.close();
	}
	public static Transferencia buscarTransferenciaPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Transferencia.class, id);
}
}
