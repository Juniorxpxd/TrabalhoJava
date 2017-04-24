package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Cadastro;
import Banco.model.Endereco;

public class EnderecoDAO {
	private static ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	
	public static void adicionarEndereco(Endereco e){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerEndereco(Endereco e){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException c){
				System.out.println(c.toString());
			}
	}
	public static List<Endereco> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT e FROM Endereco e");
		List<Endereco> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarEndereco(Endereco e){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Endereco endereco = em.find(Endereco.class, e.getIdEnd());
		endereco.setRua(e.getRua());
		endereco.setNumero(e.getNumero());
		endereco.setBairro(e.getBairro());
		endereco.setCidade(e.getCidade());
		endereco.setEstado(e.getEstado());
		endereco.setPais(e.getPais());
		em.merge(endereco);
		em.getTransaction().commit();
		em.close();
	}
}