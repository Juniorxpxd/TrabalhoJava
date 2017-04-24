package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Pessoa;

public class PessoaDAO {
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	public static void adicionarPessoa(Pessoa p){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerPessoa(Pessoa p){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
	}
	public static List<Pessoa> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT p FROM Pessoa p");
		List<Pessoa> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarPessoa(Pessoa p){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Pessoa pessoa = em.find(Pessoa.class, p.getIdPes());
		pessoa.setPessoa(p.getPessoa());
		pessoa.setFisica(p.getFisica());
		pessoa.setJuridica(p.getJuridica());
		em.merge(pessoa);
		em.getTransaction().commit();
		em.close();
	}
	public static Pessoa buscarPessoaPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Pessoa.class, id);
	}
}
