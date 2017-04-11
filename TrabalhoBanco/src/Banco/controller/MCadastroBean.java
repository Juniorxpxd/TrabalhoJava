package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Banco.dal.CadastroDAO;
import Banco.dal.EnderecoDAO;
import Banco.model.Cadastro;
import Banco.model.Endereco;

@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private Endereco endereco = new Endereco();
	private ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public ArrayList<Cadastro> getCadastros() {
		return cadastros;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public void setCadastros(ArrayList<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	
	public String addCad(Cadastro c){
		CadastroDAO.addCadastro(c);
		System.out.println("Nome: " + c.getNome());
		return "Index.xhtml?faces-redirect=true";
	}
}
