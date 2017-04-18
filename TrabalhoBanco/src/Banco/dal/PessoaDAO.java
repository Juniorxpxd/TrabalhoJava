package Banco.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
		pessoas.remove(p);
	}
	public static List<Pessoa> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p FROM Cadastro.Pessoa p");
		List<Pessoa> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarPessoa(Pessoa p){
		for (int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getIdPes() == p.getIdPes()){
				pessoas.set(i, p);
			}
		}
	}
}
