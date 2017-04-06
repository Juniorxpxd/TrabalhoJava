package Banco.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Banco.model.Endereco;

@ManagedBean(name = "mEnderecoBean")
public class MEnderecoBean {
	private Endereco ende = new Endereco();
	private int idCadastro;
	
	public Endereco getEnde() {
		return ende;
	}
	public int getIdCadastro() {
		return idCadastro;
	}
	public void setEnde(Endereco ende) {
		this.ende = ende;
	}
	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}
	
	
	
}
