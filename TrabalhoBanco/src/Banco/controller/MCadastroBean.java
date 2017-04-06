package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.model.Endereco;
import Banco.dal.CadastroDAO;
import Banco.dal.EnderecoDAO;

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

	public ArrayList<Cadastro> getCadastros() {
		return CadastroDAO.retornarLista();
	}
	
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastros(ArrayList<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	
	public String gravarCadastro(Cadastro c) {
		CadastroDAO.addCadastro(c);
		System.out.println("Nome: " + c.getNome() + " Email: " + c.getEmail() + " Senha: " + c.getSenha() + " Sexo: " + c.getSexo() + " Telefone: " + c.getTelefone() + 
				" Rua: " + c.getEndereco().getRua());
		return "Index.xhtml?faces-redirect=true";
	}
}
