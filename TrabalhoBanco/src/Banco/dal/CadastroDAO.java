package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Cadastro;
import Banco.model.Emprestimo;
import Banco.model.Pagamento;
import Banco.model.Transferencia;

public class CadastroDAO {
	private static ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();

	public static void adicionarCadastro(Cadastro c) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public static void removerCadastro(Cadastro c) {
		try {
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			c = em.getReference(Cadastro.class, c.getIdCad());
			em.remove(c);
			em.getTransaction().commit();
			em.close();
		} catch (RollbackException e) {
			System.out.println(e.toString());
		}
	}

	public static List<Cadastro> retornarLista() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Cadastro c");
		List<Cadastro> lista = q.getResultList();
		em.close();
		return lista;
	}

	public static void alterarCadastro(Cadastro c) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Cadastro cadastro = em.find(Cadastro.class, c.getIdCad());
		cadastro.setNome(c.getNome());
		cadastro.setEmail(c.getEmail());
		cadastro.setSenha(c.getSenha());
		cadastro.setTelefone(c.getTelefone());
		cadastro.setDataNasc(c.getDataNasc());
		cadastro.setSexo(c.getSexo());
		cadastro.setRg(c.getRg());
		cadastro.setAgencia(c.getAgencia());
		cadastro.setSaldo(c.getSaldo());
		cadastro.setConta(c.getConta());
		cadastro.setPoupanca(c.getPoupanca());
		cadastro.setCartao(c.getCartao());
		em.merge(cadastro);
		em.getTransaction().commit();
		em.close();
	}

	public static Cadastro buscarCadastroPorId(int id) {
		EntityManager em = Conexao.getEntityManager();
		return em.find(Cadastro.class, id);
	}

	public static Cadastro getCadastro(String email, String senha){
		try {
			EntityManager em = Conexao.getEntityManager();
			Cadastro cadastro = (Cadastro) em .createQuery("SELECT c FROM Cadastro c where c.email = :email and c.senha = :senha").setParameter("email", email).setParameter("senha", senha).getSingleResult();
			return cadastro;
		} catch (NoResultException e) {
			return null;
		}
	}
	public static Cadastro buscarCadastroPorNome(String nome){
		try {
			EntityManager em = Conexao.getEntityManager();
			Cadastro cadastro = (Cadastro) em.createQuery("SELECT c FROM Cadastro c WHERE c.nome = :nome").setParameter("nome", nome).getSingleResult();
			return cadastro;
		} catch (NoResultException e) {
			return null;
		}
	}
}
