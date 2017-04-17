package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		enderecos.remove(e);
	}
	public static List<Endereco> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT e FROM Cadastro.Endereco e");
		List<Endereco> lista = q.getResultList();
		em.close();
		return lista;
		
	}
}