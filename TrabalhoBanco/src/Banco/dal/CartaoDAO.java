package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Cartao;
import Banco.model.Endereco;

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
			d = em.getReference(Cartao.class, d.getIdCar());
			em.remove(d);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException c){
				System.out.println(c.toString());
			}
		}
	public static List<Cartao> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Cartao c");
		List<Cartao> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarCartao(Cartao d){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Cartao cartao = em.find(Cartao.class, d.getIdCar());
		cartao.setTipoCartao(d.getTipoCartao());
		cartao.setRenda(d.getRenda());
		em.merge(cartao);
		em.getTransaction().commit();
		em.close();
	}
	public static Cartao buscarCartaoPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Cartao.class, id);
	}
}
