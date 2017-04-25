package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.CadastroDAO;
import Banco.dal.PessoaDAO;
import Banco.model.Cadastro;
import Banco.model.Pessoa;

@SessionScoped
@ManagedBean(name = "mPessoaBean")
public class MPessoaBean {
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public List<Pessoa> getPessoas() {
		return PessoaDAO.retornarLista();
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public String enviarDadosParaAlterar(Pessoa p) {
		this.pessoa = p;
		return "AlterarPessoa.xhtml?faces-redirect=true";
	}
	public String removerPessoa(Pessoa p) {
		PessoaDAO.removerPessoa(p);
		pessoa = new Pessoa();
		return "ListarPessoa.xhtml?faces-redirect=true";
	}

	public String alterarPessoa(Pessoa p) {
		PessoaDAO.alterarPessoa(p);
		pessoa = new Pessoa();
		return "ListarPessoa.xhtml?faces-redirect=true";
	}
	public String gravarPessoa(Pessoa p){
		Cadastro c = CadastroDAO.buscarCadastroPorId(idCad);
		p.setCadastro(c);
		PessoaDAO.adicionarPessoa(p);
		pessoa = new Pessoa();
		return "Cartao.xhtml?faces-redirect=true";
	}
}
