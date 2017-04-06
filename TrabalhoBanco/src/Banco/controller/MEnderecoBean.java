package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Banco.dal.CadastroDAO;
import Banco.dal.EnderecoDAO;
import Banco.model.Cadastro;
import Banco.model.Endereco;

@ManagedBean(name = "mCadastroBean")
public class MEnderecoBean {
	private Endereco endereco = new Endereco();
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private int idCad;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}
	public int getIdCad() {
		return idCad;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	
	public String gravarEndereco(Endereco e){
		Cadastro c = CadastroDAO.buscarCadastroPorID(idCad);
		e.setCadastros(c);
		EnderecoDAO.adicionarEndereco(e);
		System.out.println(" Rua: " + e.getRua());
		return "Index.xhtml?faces-redirect=true";
	}
	
}
