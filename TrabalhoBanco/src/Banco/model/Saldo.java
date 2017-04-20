package Banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Saldo")
public class Saldo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSaldo;
	private double saldo;
	@OneToOne
	private Cadastro cadastro;
	
	public int getIdSaldo() {
		return idSaldo;
	}
	public double getSaldo() {
		return saldo;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setIdSaldo(int idSaldo) {
		this.idSaldo = idSaldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
}
