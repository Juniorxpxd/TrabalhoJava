package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.AgenciaDAO;
import Banco.dal.CadastroDAO;
import Banco.dal.TransferenciaDAO;
import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.model.Transferencia;

@SessionScoped
@ManagedBean(name = "mTransferenciaBean")
public class MTransferenciaBean {
	private Transferencia transferencia = new Transferencia();
	private List<Transferencia> transferencias = new ArrayList<Transferencia>();
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
	public Transferencia getTransferencia() {
		return transferencia;
	}
	public List<Transferencia> getTransferencias() {
		return TransferenciaDAO.retornarLista();
	}
	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
	public String gravarTransferencia(Transferencia t){
		Cadastro e = CadastroDAO.buscarCadastroPorId(idCad);
		Cadastro f = CadastroDAO.buscarCadastroPorId(conta);
		Agencia g = AgenciaDAO.buscarAgenciaPorId(agencia);
		t.setAgencia(g);
		t.setCadastro2(f);
		t.setCadastro(e);
		TransferenciaDAO.adicionarTransferencia(t);
		transferencia = new Transferencia();
		return "ComprovanteTra.xhtml?faces-redirect=true";
	}
}
