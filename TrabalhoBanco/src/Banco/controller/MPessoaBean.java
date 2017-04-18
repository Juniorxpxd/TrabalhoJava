package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import Banco.dal.PessoaDAO;
import Banco.model.Pessoa;

@ManagedBean(name = "mPessoaBean")
public class MPessoaBean {
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public String gravarPessoa(Pessoa p){
		PessoaDAO.adicionarPessoa(p);
		return "Cartao.xhtml?faces-redirect=true";
	}
}
