package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import Banco.dal.AgenciaDAO;
import Banco.dal.CadastroDAO;
import Banco.model.Agencia;
import Banco.model.Cadastro;

@SessionScoped
@ManagedBean(name = "mCadastroBean")
public class MCadastroBean {
	private Cadastro cadastro = new Cadastro();
	private List<Cadastro> cadastros = new ArrayList<Cadastro>();
	private CadastroDAO cadastroDAO = new CadastroDAO();
	private int idAgen;

	public int getIdAgen() {
		return idAgen;
	}
	public void setIdAgen(int idAgen) {
		this.idAgen = idAgen;
	}
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
	}
	
	public String enviarDadosParaAlterar(Cadastro c) {
		this.cadastro = c;
		return "AlterarCliente.xhtml?faces-redirect=true";
	}

	public String alterarCadastro(Cadastro c) {
		CadastroDAO.alterarCadastro(c);
		cadastro = new Cadastro();
		return "ListarCliente.xhtml?faces-redirect=true";
	}
	
	public String removerCadastro(Cadastro c) {
		CadastroDAO.removerCadastro(c);
		cadastro = new Cadastro();
		return "ListarCliente.xhtml?faces-redirect=true";
	}
	
	public String gravarCadastro(Cadastro c){
		Agencia a = AgenciaDAO.buscarAgenciaPorId(idAgen);
		c.setAgencia(a);
		CadastroDAO.adicionarCadastro(c);
		return "Endereco.xhtml?faces-redirect=true";
	}
	
	public String enviar(){
		cadastro = CadastroDAO.getCadastro(cadastro.getEmail(), cadastro.getSenha());
		if(cadastro == null){
			cadastro = new Cadastro();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!","Erro no Login!"));
		       return null;
		   } else {
			   return "AreaCliente.xhtml?faces-redirect=true";
		   }
	}
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Index.xhtml?faces-redirect=true";
	}
}
