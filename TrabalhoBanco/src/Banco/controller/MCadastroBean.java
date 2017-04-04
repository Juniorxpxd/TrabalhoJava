package Banco.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Banco.model.Cadastro;
import Banco.dal.CadastroDAO;

@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();

	public ArrayList<Cadastro> getCadastros() {
		cadastros = CadastroDAO.retornarLista();
		for (Cadastro cad : cadastros) {
			System.out.println(cad.getNome());
		}
		return cadastros;
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
		return "Index.xhtml?faces-redirect=true";
	}
}
