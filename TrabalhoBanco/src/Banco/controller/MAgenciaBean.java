package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import Banco.dal.AgenciaDAO;
import Banco.model.Agencia;

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
	public String gravarAgencia(Agencia a){
		AgenciaDAO.adicionarAgencia(a);
		return "Administrador.xhtml?faces-redirect=true";
	}
}
