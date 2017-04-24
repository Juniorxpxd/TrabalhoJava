package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import Banco.dal.ContaDAO;
import Banco.model.Conta;

@ManagedBean(name = "mContaBean")
public class MContaBean {
	private Conta conta = new Conta();
	private List<Conta> contas = new ArrayList<Conta>();
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public String gravarConta(Conta c){
		ContaDAO.adicionarConta(c);
		return "Administrador.xhtml?faces-redirect=true";
	}
}
