package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Emprestimo;

public class EmprestimoDAO {
	private static ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
	public static void adicionarEmprestimo(Emprestimo e){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerEmprestimo(Emprestimo e){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			e = em.getReference(Emprestimo.class, e.getIdEmp());
			em.remove(e);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException c){
				System.out.println(c.toString());
			}
		}
	public static List<Emprestimo> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query d = em.createQuery("SELECT e FROM Emprestimo e");
		List<Emprestimo> lista = d.getResultList();
		em.close();
		return lista;
	}
	public static void alterarEmprestimo(Emprestimo e){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Emprestimo emprestimo = em.find(Emprestimo.class, e.getIdEmp());
		emprestimo.setSaldoE(e.getSaldoE());
		emprestimo.setMotivo(e.getMotivo());
		emprestimo.setData(e.getData());
		em.merge(emprestimo);
		em.getTransaction().commit();
		em.close();
	}
	public static Emprestimo buscarEmprestimoPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Emprestimo.class, id);
}
}
