package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAgen;
	private String nome;
	private String agencia;
	
	public int getIdAgen() {
		return idAgen;
	}
	public void setIdAgen(int idAgen) {
		this.idAgen = idAgen;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
