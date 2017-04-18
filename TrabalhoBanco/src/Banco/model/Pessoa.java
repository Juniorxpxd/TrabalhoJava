package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cadastro.Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPes;
	private String pessoa;
	private String juridica;
	private String fisica;
	
	public int getIdPes() {
		return idPes;
	}
	public void setIdPes(int idPes) {
		this.idPes = idPes;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public String getJuridica() {
		return juridica;
	}
	public String getFisica() {
		return fisica;
	}
	public void setJuridica(String juridica) {
		this.juridica = juridica;
	}
	public void setFisica(String fisica) {
		this.fisica = fisica;
	}
}
