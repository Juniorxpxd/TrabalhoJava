package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Banco.dal.CadastroDAO;
import Banco.dal.EnderecoDAO;
import Banco.model.Cadastro;
import Banco.model.Endereco;

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
		return enderecos;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public String gravarEndereco(Endereco e){
		Cadastro c = CadastroDAO.buscarCadastroPorId(idCad);
		e.setCadastro(c);
		EnderecoDAO.adicionarEndereco(e);
		return "Pessoa.xhtml?faces-redirect=true";
	}
}