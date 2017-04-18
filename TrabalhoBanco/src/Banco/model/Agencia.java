package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cadastro.Agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAgen;
	private int agencia;
	private int conta;
	
	public int getIdAgen() {
		return idAgen;
	}
	public void setIdAgen(int idAgen) {
		this.idAgen = idAgen;
	}
	public int getAgencia() {
		return agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	
	
}
