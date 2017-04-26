package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Administrador;

public class AdministradorDAO {
	private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();

	public static void adicionarAdministrador(Administrador a) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	public static void removerAdministrador(Administrador a) {
		try {
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			a = em.getReference(Administrador.class, a.getIdAdm());
			em.remove(a);
			em.getTransaction().commit();
			em.close();
		} catch (RollbackException e) {
			System.out.println(e.toString());
		}
	}

	public static List<Administrador> retornarLista() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT a FROM Administrador a");
		List<Administrador> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static Administrador getAdministrador(String email, String senha){
		try {
			EntityManager em = Conexao.getEntityManager();
			Administrador administrador = (Administrador) em .createQuery("SELECT a FROM Administrador a where a.email = :email and a.senha = :senha").setParameter("email", email).setParameter("senha", senha).getSingleResult();
			return administrador;
		} catch (NoResultException e) {
			return null;
		}
	}
}
