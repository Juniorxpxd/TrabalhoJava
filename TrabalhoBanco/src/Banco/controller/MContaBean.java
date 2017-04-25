package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.ContaDAO;
import Banco.model.Conta;

@SessionScoped
@ManagedBean(name = "mContaBean")
public class MContaBean {
	private Conta conta = new Conta();
	private List<Conta> contas = new ArrayList<Conta>();
	private int idConta;
	
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
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
		return "CadastroCliente.xhtml?faces-redirect=true";
	}
}
