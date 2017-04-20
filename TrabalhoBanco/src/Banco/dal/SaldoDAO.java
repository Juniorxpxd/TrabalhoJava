package Banco.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import Banco.model.Saldo;

public class SaldoDAO {
private static ArrayList<Saldo> saldos = new ArrayList<Saldo>();
	
	public static void adicionarSaldo(Saldo s){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public static void removerSaldo(Saldo s){
		try{
			EntityManager em = Conexao.getEntityManager();
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			em.close();
			}catch(RollbackException c){
				System.out.println(c.toString());
			}
	}
	public static List<Saldo> retornarLista(){
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT s FROM Saldo s");
		List<Saldo> lista = q.getResultList();
		em.close();
		return lista;
	}
	public static void alterarSaldo(Saldo s){
		for (int i = 0; i < saldos.size(); i++) {
			if(saldos.get(i).getIdSaldo() == s.getIdSaldo()){
				saldos.set(i, s);
			}
		}
	}
}
