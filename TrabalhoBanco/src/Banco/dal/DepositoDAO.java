package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Deposito;

public class DepositoDAO {
	private static ArrayList<Deposito> deposito = new ArrayList<Deposito>();
	public static void adicionarDeposito(Deposito d){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerPessoa(Deposito d){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			d = em.getReference(Deposito.class, d.getIdDeposito());
			em.remove(d);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
		}
	public static List<Deposito> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT d FROM Deposito d");
		List<Deposito> lista = d.getResultList();
		em.close();
		return lista;
	}
	public static void alterarDeposito(Deposito d){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Deposito deposito = em.find(Deposito.class, d.getIdDeposito());
		deposito.setQuantidade(d.getQuantidade());
		
		em.merge(deposito);
		em.getTransaction().commit();
		em.close();
	}
	public static Deposito buscarDepositoPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Deposito.class, id);
}
}
