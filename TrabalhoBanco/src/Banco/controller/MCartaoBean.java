package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Banco.dal.CadastroDAO;
import Banco.dal.CartaoDAO;
import Banco.dal.EnderecoDAO;
import Banco.model.Cadastro;
import Banco.model.Cartao;
import Banco.model.Endereco;

@SessionScoped
@ManagedBean(name = "mCartaoBean")
public class MCartaoBean {
	private Cartao cartao = new Cartao();
	private List<Cartao> cartoes = new ArrayList<Cartao>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public List<Cartao> getCartoes() {
		return CartaoDAO.retornarLista();
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	public String enviarDadosParaAlterar(Cartao c){
		this.cartao = c;
		return "AlterarCartao.xhtml?faces-redirect=true";
	}
	
	public String removerCartao(Cartao c) {
		CartaoDAO.removerCartao(c);
		cartao = new Cartao();
		return "ListarCartao.xhtml?faces-redirect=true";
	}

	public String alterarCartao(Cartao c) {
		CartaoDAO.alterarCartao(c);
		cartao = new Cartao();
		return "ListarCartao.xhtml?faces-redirect=true";
	}
	public String gravarCartao(Cartao c){
		Cadastro e = CadastroDAO.buscarCadastroPorId(idCad);
		c.setCadastro(e);
		CartaoDAO.adicionarCartao(c);
		return "Index.xhtml?faces-redirect=true";
	}
}
