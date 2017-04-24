package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import Banco.dal.CadastroDAO;
import Banco.dal.CartaoDAO;
import Banco.model.Cadastro;
import Banco.model.Cartao;

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
	
	public String gravarCartao(Cartao c){
		Cadastro e = CadastroDAO.buscarCadastroPorId(idCad);
		c.setCadastro(e);
		CartaoDAO.adicionarCartao(c);
		return "Index.xhtml?faces-redirect=true";
	}
}
