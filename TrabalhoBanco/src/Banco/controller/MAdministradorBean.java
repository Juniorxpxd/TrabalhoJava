package Banco.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Banco.dal.AdministradorDAO;
import Banco.dal.AgenciaDAO;
import Banco.model.Administrador;
import Banco.model.Agencia;

@SessionScoped
@ManagedBean(name = "mAdministradorBean")
public class MAdministradorBean {
	private Administrador administrador = new Administrador();
	private List<Administrador> administradores = new ArrayList<Administrador>();
	private AdministradorDAO administradorDAO = new AdministradorDAO();

	public Administrador getAdministrador() {
		return administrador;
	}
	public List<Administrador> getAdministradores() {
		return AdministradorDAO.retornarLista();
	}
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	public String enviarDadosParaAlterar(Administrador a) {
		this.administrador = a;
		return "AlterarAdm.xhtml?faces-redirect=true";
	}
	public String alterarAdm(Administrador a) {
		AdministradorDAO.alterarAdm(a);
		administrador = new Administrador();
		return "ListarAdm.xhtml?faces-redirect=true";
	}
	public String removerAdministrador(Administrador a) {
		AdministradorDAO.removerAdministrador(a);
		administrador = new Administrador();
		return "ListarAdm.xhtml?faces-redirect=true";
	}
	public String gravarAdministrador(Administrador a){
		AdministradorDAO.adicionarAdministrador(a);
		administrador = new Administrador();
		return "Login.xhtml?faces-redirect=true";
	}
	public String enviar(){
		administrador = AdministradorDAO.getAdministrador(administrador.getEmail(), administrador.getSenha());
		if(administrador == null){
			administrador = new Administrador();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!","Erro no Login!"));
		       return null;
		   } else {
			   return "Administrador.xhtml?faces-redirect=true";
		   }
	}
	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "Index.xhtml?faces-redirect=true";
	}
}
