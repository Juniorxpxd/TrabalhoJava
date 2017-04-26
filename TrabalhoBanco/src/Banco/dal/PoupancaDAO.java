package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Poupanca;

public class PoupancaDAO {
	private static ArrayList<Poupanca> poupancas = new ArrayList<Poupanca>();

	public static void adicionarPoupanca(Poupanca p) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public static void removerPoupanca(Poupanca p) {
		try {
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			p = em.getReference(Poupanca.class, p.getIdPoup());
			em.remove(p);
			em.getTransaction().commit();
			em.close();
		} catch (RollbackException e) {
			System.out.println(e.toString());
		}
	}

	public static List<Poupanca> retornarLista() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT p FROM Poupanca p");
		List<Poupanca> lista = q.getResultList();
		em.close();
		return lista;
	}

	public static void alterarPoupanca(Poupanca p) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Poupanca poupanca = em.find(Poupanca.class, p.getIdPoup());
		poupanca.setPoupanca(p.getPoupanca());
		em.merge(poupanca);
		em.getTransaction().commit();
		em.close();
	}
}