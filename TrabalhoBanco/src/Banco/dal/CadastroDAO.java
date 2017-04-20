package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Cadastro;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	public static void adicionarCadastro(Cadastro c){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerCadastro(Cadastro c){
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
	public static List<Cadastro> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT c FROM Cadastro c");
		List<Cadastro> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarCadastro(Cadastro c){
		for (int i = 0; i < cadastros.size(); i++) {
			if(cadastros.get(i).getIdCad() == c.getIdCad()){
				cadastros.set(i, c);
			}
		}
	}
	public static Cadastro buscarCadastroPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Cadastro.class, id);
	}
	
	public static Cadastro getCadastro(String email, String senha){
		try{
			EntityManager em = Conexao.getEntityManager();
			Cadastro cadastro = (Cadastro) em.createQuery("SELECT c FROM Cadastro c where c.email = :email and c.senha = :senha").setParameter("email", email).setParameter("senha", senha).getSingleResult();
		return cadastro;
		}catch (NoResultException e){
			 return null;
		}
	}
}
