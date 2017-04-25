package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.AgenciaDAO;
import Banco.model.Agencia;

@SessionScoped
@ManagedBean(name = "mAgenciaBean")
public class MAgenciaBean {
	private Agencia agencia = new Agencia();
	private List<Agencia> agencias = new ArrayList<Agencia>();
	
	public Agencia getAgencia() {
		return agencia;
	}
	public List<Agencia> getAgencias() {
		return AgenciaDAO.retornarLista();
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
	public String enviarDadosParaAlterar(Agencia a) {
		this.agencia = a;
		return "AlterarAgencia.xhtml?faces-redirect=true";
	}
	public String alterarAgencia(Agencia a) {
		AgenciaDAO.alterarAgencia(a);
		agencia = new Agencia();
		return "ListarAgencia.xhtml?faces-redirect=true";
	}
	public String removerAgencia(Agencia a) {
		AgenciaDAO.removerAgencia(a);
		agencia = new Agencia();
		return "ListarAgencia.xhtml?faces-redirect=true";
	}
	public String gravarAgencia(Agencia a){
		AgenciaDAO.adicionarAgencia(a);
		agencia = new Agencia();
		return "Administrador.xhtml?faces-redirect=true";
	}
}
