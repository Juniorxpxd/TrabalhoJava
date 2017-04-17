package Banco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import Banco.dal.EnderecoDAO;
import Banco.model.Endereco;

@ManagedBean(name = "mEnderecoBean")
public class MEnderecoBean {
	private Endereco endereco = new Endereco();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private int idCad;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public int getIdCad() {
		return idCad;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public void setIdCad(int idCad) {
		this.idCad = idCad;
	}
	
	public String gravarEndereco(Endereco e){
		EnderecoDAO.adicionarEndereco(e);
		return "Index.xhtml?faces-redirect=true";
	}
	
}