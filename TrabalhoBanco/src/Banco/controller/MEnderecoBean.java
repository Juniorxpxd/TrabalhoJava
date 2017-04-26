package Banco.controller;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Banco.dal.CadastroDAO;
import Banco.dal.EnderecoDAO;
import Banco.model.Cadastro;
import Banco.model.Endereco;

@SessionScoped
@ManagedBean(name = "mEnderecoBean")
public class MEnderecoBean {
	private Endereco endereco = new Endereco();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private int idCad;
	
	public int getIdCad() {
		return idCad;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public List<Endereco> getEnderecos() {
		return EnderecoDAO.retornarLista();
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public String enviarDadosParaAlterar(Endereco e){
		this.endereco = e;
		return "AlterarEndereco.xhtml?faces-redirect=true";
	}
	
	public String removerEndereco(Endereco e) {
		EnderecoDAO.removerEndereco(e);
		endereco = new Endereco();
		return "ListarEndereco.xhtml?faces-redirect=true";
	}

	public String alterarEndereco(Endereco e) {
		EnderecoDAO.alterarEndereco(e);
		endereco = new Endereco();
		return "ListarEndereco.xhtml?faces-redirect=true";
	}
	public String gravarEndereco(Endereco e){
		Cadastro c = CadastroDAO.buscarCadastroPorId(idCad);
		e.setCadastro(c);
		EnderecoDAO.adicionarEndereco(e);
		endereco = new Endereco();
		return "Pessoa.xhtml?faces-redirect=true";
	}
	public String buscarEndereco(){
		 endereco = EnderecoDAO.buscarEnderecoPorCEP(endereco.getCep());
			if(endereco == null){
				endereco = new Endereco();
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "CEP não encontrado!","Erro na Busca!"));
			       return null;
			   } else {
				   return "EnderecoEncontrado.xhtml?faces-redirect=true";
			   }
		}
}