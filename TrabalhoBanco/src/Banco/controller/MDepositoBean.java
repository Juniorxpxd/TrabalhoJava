package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.AgenciaDAO;
import Banco.dal.CadastroDAO;
import Banco.dal.DepositoDAO;
import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.model.Deposito;

@SessionScoped
@ManagedBean(name = "mDepositoBean")
public class MDepositoBean {
	private Deposito deposito = new Deposito();
	private List<Deposito> depositos = new ArrayList<Deposito>();
	private int idCad;
	private int conta;
	private int agencia;
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public List<Deposito> getDepositos() {
		return DepositoDAO.retornarLista();
	}
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}
	public String gravarDeposito(Deposito d){
		Cadastro e = CadastroDAO.buscarCadastroPorId(idCad);
		Cadastro f = CadastroDAO.buscarCadastroPorId(conta);
		Agencia g = AgenciaDAO.buscarAgenciaPorId(agencia);
		d.setAgencia(g);
		d.setCadastro2(f);
		d.setCadastro(e);
		DepositoDAO.adicionarDeposito(d);
		deposito = new Deposito();
		return "ComprovanteDep.xhtml?faces-redirect=true";
	}
}
