package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import Banco.dal.CadastroDAO;
import Banco.model.Cadastro;

@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public ArrayList<Cadastro> getCadastros() {
		return CadastroDAO.retornarLista();
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public void setCadastros(ArrayList<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	
	public String addCad(Cadastro c){
		CadastroDAO.addCadastro(c);
		System.out.println("Nome: " + c.getNome() + " Email: " + c.getEmail() + " Senha: " + c.getSenha() + " Telefone: " + c.getTelefone() + " Data: " + c.getData() + " Sexo: " + c.getSexo() + " RG:" + c.getRg());
		return "Endereco.xhtml?faces-redirect=true";
	}
}
