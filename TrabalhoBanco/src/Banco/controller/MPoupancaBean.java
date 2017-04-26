package Banco.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.PoupancaDAO;
import Banco.model.Poupanca;

@SessionScoped
@ManagedBean(name = "mPoupancaBean")
public class MPoupancaBean {
	private Poupanca poupanca = new Poupanca();
	private List<Poupanca> poupancas = new ArrayList<Poupanca>();
	
	public Poupanca getPoupanca() {
		return poupanca;
	}
	public List<Poupanca> getPoupancas() {
		return poupancas;
	}
	public void setPoupanca(Poupanca poupanca) {
		this.poupanca = poupanca;
	}
	public void setPoupancas(List<Poupanca> poupancas) {
		this.poupancas = poupancas;
	}
	public String gravarPoupanca(Poupanca p){
		PoupancaDAO.adicionarPoupanca(p);
		poupanca = new Poupanca();
		return "Poupanca.xhtml?faces-redirect=true";
	}
}
