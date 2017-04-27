package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Pagamento;

public class PagamentoDAO {
	private static ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
	public static void adicionarPagamento(Pagamento p){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerPagamento(Pagamento p){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			p = em.getReference(Pagamento.class, p.getIdPag());
			em.remove(p);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException e){
				System.out.println(e.toString());
			}
		}
	public static List<Pagamento> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		Query d = em.createQuery("SELECT p FROM Pagamento p");
		List<Pagamento> lista = d.getResultList();
		em.close();
		return lista;
	}
	public static void alterarPagamento(Pagamento p){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Pagamento pagamento = em.find(Pagamento.class, p.getIdPag());
		pagamento.setCodBarras(p.getCodBarras());
		pagamento.setData(p.getData());
		pagamento.setValor(p.getValor());
		em.merge(pagamento);
		em.getTransaction().commit();
		em.close();
	}
	public static Pagamento buscarPagamentoPorId(int id){
		EntityManager em = Conexao.getEntityManager();
		return em.find(Pagamento.class, id);
}
}
