package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Banco.model.Agencia;
import Banco.model.Cadastro;
import Banco.dal.CadastroDAO;

@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private Agencia cadastroAgencia = new Agencia();
	private ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();

	public ArrayList<Cadastro> getCadastros() {
		cadastros = CadastroDAO.retornarLista();
		for (Cadastro cad : cadastros) {
			System.out.println(cad.getNome());
		}
		return cadastros;
	}
	
	public Agencia getCadastroAgencia() {
		return cadastroAgencia;
	}
	public void setCadastroAgencia(Agencia cadastroAgencia) {
		this.cadastroAgencia = cadastroAgencia;
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
		System.out.println("Nome: " + c.getNome() + " Email: " + c.getEmail() + " Senha: " + c.getSenha() + " Sexo: " + c.getSexo() + " Telefone: " + c.getTelefone() + " Endereço: " + c.getEndereco());
		return "Index.xhtml?faces-redirect=true";
	}
}
