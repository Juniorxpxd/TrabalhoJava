package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Banco.model.Cartao;

public class CartaoDAO {
	private static ArrayList<Cartao> cartoes = new ArrayList<Cartao>();
	public static void adicionarCartao(Cartao c){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerCartao(Cartao c){
		cartoes.remove(c);
	}
	public static List<Cartao> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT c FROM Cadastro.Cartao c");
		List<Cartao> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarCartao(Cartao c){
		for (int i = 0; i < cartoes.size(); i++) {
			if(cartoes.get(i).getIdCar() == c.getIdCar()){
				cartoes.set(i, c);
			}
		}
	}
}
