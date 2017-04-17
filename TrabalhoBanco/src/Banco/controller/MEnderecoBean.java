package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Banco.dal.EnderecoDAO;
import Banco.model.Endereco;

@ManagedBean(name = "mEnderecoBean")
public class MEnderecoBean {
	private Endereco endereco = new Endereco();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Endereco getEndereco() {
		return endereco;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public String gravarEndereco(Endereco e){
		EnderecoDAO.adicionarEndereco(e);
		HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
		return "Index.xhtml?faces-redirect=true";
	}
	
}