package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Cartao;

public class CartaoDAO {
	private static ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
	public static void adicionarCartao(Cartao d){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(d);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerCartao(Cartao d){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(d);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
	}
	public static List<Cartao> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT c FROM Cartao c");
		List<Cartao> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarCartao(Cartao d){
		for (int i = 0; i < cartoes.size(); i++) {
			if(cartoes.get(i).getIdCar() == d.getIdCar()){
				cartoes.set(i, d);
			}
		}
	}
	public static Cartao buscarCartaoPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Cartao.class, id);
	}
}
