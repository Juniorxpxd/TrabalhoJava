package Banco.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import Banco.dal.CadastroDAO;
import Banco.model.Cadastro;

@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private List<Cadastro> cadastros = new ArrayList<Cadastro>();
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public List<Cadastro> getCadastros() {
		return CadastroDAO.retornarLista();
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	
	public String addCad(Cadastro c){
		CadastroDAO.addCadastro(c);
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println(req.getParameter("id"));
		return "Endereco.xhtml?faces-redirect=true";
	}

}
